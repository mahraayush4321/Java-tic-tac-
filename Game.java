import java.util.Scanner;

class TicTac {

    static char[][] board;

    public TicTac() {
        board = new char[3][3]; // 2D array
        initboard();
    }

    void initboard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
    }

    static void displayboard() {
        System.out.println("-------------");
        for (int i = 0; i < board.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    static void placeMark(int row, int col, char mark) {
        if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {
            board[row][col] = mark;
        } else {
            System.out.println("INVALID POSITION");
        }

    }

    static boolean checkColumnWin() {
        for (int j = 0; j <= 2; j++) {
            if (board[0][j] != ' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return true;
            }
        }
        return false;
    }

    static boolean checkRowWin() {
        for (int i = 0; i <= 2; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }
        return false;
    }

    static boolean checkDiagonalWin() {
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]
                || board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        } else {
            return false;
        }
    }
}

class player {
    String name;
    char mark;

    public player(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }

    void makeMove() {
        Scanner sc = new Scanner(System.in);
        int row;
        int col;
        do {
            System.out.println("Enter the row and col ");
            row = sc.nextInt();
            col = sc.nextInt();
        } while (!isValidMove(row, col));

        TicTac.placeMark(row, col, mark);
    }

    boolean isValidMove(int row, int col) {
        if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {
            if (TicTac.board[row][col] == ' ') {
                return true;
            }

        }
        return false;
    }

}

public class Game {
    public static void main(String[] args) {
        TicTac T = new TicTac();
        player p1 = new player("Tanishq", '0');
        player p2 = new player("priyanshu", 'X');

        player cp;
        cp = p1;
        while (true) {
            System.out.println(cp.name + " turn");
            cp.makeMove();
            TicTac.displayboard();

            if (TicTac.checkColumnWin() || TicTac.checkRowWin() || TicTac.checkDiagonalWin()) {
                System.out.println(cp.name + "  Has won");
                break;
            } else {
                if (cp == p1) {
                    cp = p2;
                } else {
                    cp = p1;
                }
            }

        }
    }
}
