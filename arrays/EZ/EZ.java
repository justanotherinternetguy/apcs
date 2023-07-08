import java.util.Random;

public class EZ {
  private static final double RANGE_START = 0.0;
  private static final double RANGE_END = 1.0;

  public static void main(String[] args) {
    int N = 1000; // Number of iterations
    int totalFractions = 0; // Total number of fractions required across all iterations

    for (int i = 0; i < N; i++) {
      int fractionsRequired = accumulateFractions();
      totalFractions += fractionsRequired;
    }

    double averageFractions = (double) totalFractions / N;
    System.out.println("Average number of fractions required: " + averageFractions);
  }

  private static int accumulateFractions() {
    double sum = 0.0;
    int fractionsRequired = 0;

    Random random = new Random();

    while (sum <= RANGE_END) {
      double fraction = RANGE_START + random.nextDouble() * (RANGE_END - RANGE_START);
      sum += fraction;
      fractionsRequired++;
    }

    return fractionsRequired;
  }
}
