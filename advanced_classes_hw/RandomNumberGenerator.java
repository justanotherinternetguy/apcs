import java.util.Random;

public class RandomNumberGenerator {

    public static void main(String[] args) {
        int min = 1;
        int max = 100;
        int odd = 1;
        int even = -1;
        int prime = 1;

        int randomNumber = generateRandomNumber(min, max, odd, even, prime);

        if (randomNumber != -1) {
            System.out.println("random number: " + randomNumber);
        } else {
            System.out.println("not possible :3");
        }
    }

    public static int generateRandomNumber(int min, int max, int odd, int even, int prime) {
        Random random = new Random();

        if (odd != -1 && even != -1) {
            System.out.println("not possible :3");
            return -1;
        }

        int randomNumber;
        boolean isValid;

        do {
            randomNumber = random.nextInt((max - min) + 1) + min;

            isValid = (odd == -1 || randomNumber % 2 != 0) &&
                      (even == -1 || randomNumber % 2 == 0) &&
                      (prime == -1 || isPrime(randomNumber));

        } while (!isValid);

        return randomNumber;
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
