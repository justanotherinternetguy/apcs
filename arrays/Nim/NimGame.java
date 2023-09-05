import java.util.Scanner;

public class NimGame {
    private static int[] piles = {3, 5, 8};

    static int currentPlayer = 1;

    public static void main(String[] args) {

        System.out.println("Welcome to Nim Game!");

        while (true) {
            System.out.println("\nCurrent Piles:");
            displayPiles();

            int selectedPile = selectPile();
            int stonesToRemove = selectStones(piles[selectedPile]);

            piles[selectedPile] -= stonesToRemove;

            if (isGameOver()) {
                System.out.println("\nPlayer " + currentPlayer + " LOSES!");
                break;
            }

            currentPlayer = (currentPlayer == 1) ? 2 : 1;
        }
    }

    public static void displayPiles() {
	if (currentPlayer == 1) {
	    System.out.println("PLAYER 1 MOVES --->");
	}
	if (currentPlayer == 2) {
	    System.out.println("PLAYER 2 MOVES --->");
	}
        for (int i = 0; i < piles.length; i++) {
            System.out.println("Pile " + i + ": " + piles[i] + " stones");
        }
    }

    public static int selectPile() {
        Scanner scanner = new Scanner(System.in);
        int selectedPile;

        while (true) {
            System.out.print("\nSelect a pile (0-2): ");
            selectedPile = scanner.nextInt();

            if (selectedPile >= 0 && selectedPile <= 2 && piles[selectedPile] > 0) {
                break;
            } else {
                System.out.println("Invalid pile selection. Try again.");
            }
        }

        return selectedPile;
    }

    public static int selectStones(int maxStones) {
        Scanner scanner = new Scanner(System.in);
        int stonesToRemove;

        while (true) {
            System.out.print("Select number of stones to remove (1-" + maxStones + "): ");
            stonesToRemove = scanner.nextInt();

            if (stonesToRemove >= 1 && stonesToRemove <= maxStones) {
                break;
            } else {
                System.out.println("Invalid number of stones. Try again.");
            }
        }

        return stonesToRemove;
    }

    public static boolean isGameOver() {
        for (int pile : piles) {
            if (pile > 0) {
                return false;
            }
        }
        return true;
    }
}
