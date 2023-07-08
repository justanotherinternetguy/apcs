import java.util.Scanner;

public class TicTacToe {
  private char[][] board;
  private char currentPlayer;

  public TicTacToe() {
    board = new char[3][3];
    currentPlayer = 'X';

    // Initialize the board with empty spaces
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        board[i][j] = ' ';
      }
    }
  }

  public void playGame() {
    boolean gameWon = false;
    Scanner scanner = new Scanner(System.in);

    while (!gameWon) {
      // Print the current board
      printBoard();

      // Get the current player's move
      System.out.println("Player " + currentPlayer + ", enter your move (row and column): ");
      int row = scanner.nextInt();
      int col = scanner.nextInt();

      // Make the move
      makeMove(row, col);

      // Check if the current player has won
      if (checkWin()) {
        gameWon = true;
        System.out.println("Player " + currentPlayer + " wins!");
      }

      // Check if the game is a draw
      if (!gameWon && isBoardFull()) {
        gameWon = true;
        System.out.println("It's a draw!");
      }

      // Switch to the next player
      currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    // Print the final board
    printBoard();
    scanner.close();
  }

  private void printBoard() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        System.out.print(board[i][j]);
        if (j < 2) {
          System.out.print(" | ");
        }
      }
      System.out.println();
      if (i < 2) {
        System.out.println("---------");
      }
    }
    System.out.println();
  }

  private void makeMove(int row, int col) {
    if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != ' ') {
      System.out.println("Invalid move! Try again.");
    } else {
      board[row][col] = currentPlayer;
    }
  }

  private boolean checkWin() {
    // Check rows
    for (int i = 0; i < 3; i++) {
      if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
        return true;
      }
    }

    // Check columns
    for (int j = 0; j < 3; j++) {
      if (board[0][j] == currentPlayer && board[1][j] == currentPlayer && board[2][j] == currentPlayer) {
        return true;
      }
    }

    // Check diagonals
    if ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
            (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)) {
      return true;
    }

    return false;
  }

  private boolean isBoardFull() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (board[i][j] == ' ') {
          return false;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    TicTacToe game = new TicTacToe();
    game.playGame();
  }
}
