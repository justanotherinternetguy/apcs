import java.util.Random;

public class RandomIntArray {
    public static void main(String[] args) {
        Random rand = new Random();
        int maxSize = rand.nextInt(10) + 1;

        int[] randomArray = new int[maxSize];

        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = rand.nextInt(100);
        }

        System.out.println("Randomly sized array of integers:");
        for (int i = 0; i < randomArray.length; i++) {
            System.out.print(randomArray[i] + " ");
        }
    }
}

