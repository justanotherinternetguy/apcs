import java.io.*;
import java.util.*;
class RandomNum {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int randomNumber = generateRandomNumber();
        System.out.println("gen random number: " + randomNumber);

        if (randomNumber == 1) {
            // Change every number to 999
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = 999;
            }
        } else if (randomNumber == 2) {
            // Change every other number to 555
            for (int i = 0; i < numbers.length; i += 2) {
                numbers[i] = 555;
            }
        } else if (randomNumber == 3) {
            // Change every third number to 444
            for (int i = 2; i < numbers.length; i += 3) {
                numbers[i] = 444;
            }
        }

        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }

    public static int generateRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(3) + 1;
    }
}
