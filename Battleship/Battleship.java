import java.util.Random;
import java.util.Scanner;

public class Battleship {
    public static void main(String[] args) {
        char[][] board = new char[6][6];
        initializeBoard(board);
        placeShips(board);
        playGame(board);
    }

    // water ~
    public static void initializeBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '~';
            }
        }
    }

    // place ships
    public static void placeShips(char[][] board) {
        Random random = new Random();
        placeShip(board, 'B', 5, random);
        placeShip(board, 'C', 4, random);
        placeShip(board, 'S', 3, random);
    }

    public static void placeShip(char[][] board, char shipSymbol, int shipLength, Random random) {
        int row, col, direction;
        boolean isValidPlacement = false;
        while (!isValidPlacement) {
            row = random.nextInt(6);
            col = random.nextInt(6);
            direction = random.nextInt(2); // 0 for horizontal, 1 for vertical
            isValidPlacement = checkValidity(board, row, col, direction, shipLength);
            if (isValidPlacement) {
                if (direction == 0) { // horizontal
                    for (int i = col; i < col + shipLength; i++) {
                        board[row][i] = shipSymbol;
                    }
                } else { // vertical
                    for (int i = row; i < row + shipLength; i++) {
                        board[i][col] = shipSymbol;
                    }
                }
            }
        }
    }

    // check if ship placement valid
    public static boolean checkValidity(char[][] board, int row, int col, int direction, int shipLength) {
        if (direction == 0 && col + shipLength > board.length) {
            return false;
        }
        if (direction == 1 && row + shipLength > board.length) {
            return false;
        }
        if (direction == 0) {
            for (int i = col; i < col + shipLength; i++) {
                if (board[row][i] != '~') {
                    return false;
                }
            }
        } else {
            for (int i = row; i < row + shipLength; i++) {
                if (board[i][col] != '~') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void displayBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void playGame(char[][] board) {
        Scanner scanner = new Scanner(System.in);
        int misses = 0;
        while (misses < 8) {
            System.out.println("enter row and column to shoot (0-5):");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            if (row < 0 || row >= board.length || col < 0 || col >= board.length) {
                System.out.println("invalid");
                continue;
            }
            if (board[row][col] == 'B' || board[row][col] == 'S' || board[row][col] == 'C') {
                System.out.println("hit");
                board[row][col] = 'X';
                displayBoard(board);
                if (checkWin(board)) {
                    System.out.println("win - all ships sunk");
                    return;
                }
            } else {
                System.out.println("miss " + misses);
                board[row][col] = 'O';
                displayBoard(board);
                misses++;
            }
        }
        System.out.println("game over");
    }

    public static boolean checkWin(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'B' || board[i][j] == 'C' || board[i][j] == 'S') {
                    return false;
                }
            }
        }
        return true;
    }
}
