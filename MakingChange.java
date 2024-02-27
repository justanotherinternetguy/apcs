import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MakingChange {
    public static int makeChange(int n) {
        int[] coins = {25, 10, 5, 1};
        // int[] coins = {1, 5, 10, 25};
        List<List<Integer>> result = new ArrayList<>();
        helper(n, coins, 0, new ArrayList<>(), result);
        printWays(result);
        return result.size();
    }

    public static void helper(int amount, int[] coins, int index, List<Integer> current, List<List<Integer>> result) {
        if (amount == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (index >= coins.length || amount < 0)
            return;
        
        int currentCoin = coins[index];
        for (int i = 0; i * currentCoin <= amount; i++) { // all times the currentCoin can be used, start w larget
            for (int j = 0; j < i; j++)
                current.add(currentCoin);
            int remainingAmount = amount - i * currentCoin;
            helper(remainingAmount, coins, index + 1, current, result);
            for (int j = 0; j < i; j++)
                current.remove(current.size() - 1);
        }
    }

    public static void printWays(List<List<Integer>> ways) {
        for (List<Integer> way : ways) {
            System.out.print("[");
            for (int i = 0; i < way.size(); i++) {
                if (i > 0)
                    System.out.print(", ");
                System.out.print(way.get(i));
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("amount to calculate: ");
        int amount = scanner.nextInt();
        System.out.println("perm(ways):");
        int ways = makeChange(amount);
        System.out.println("len(ways): " + ways);
    }
}
