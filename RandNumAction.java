import java.util.Random;
import java.util.Arrays;

public class RandNumAction {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] array = generateRandomIntArray(10);
        System.out.println("original Array: " + Arrays.toString(array));

        int randomAction = generateRandomNumber(1, 3);

        switch (randomAction) {
            case 1:
                changeTo999(array);
                System.out.println("every number to 999");
                break;
            case 2:
                changeTo555(array);
                System.out.println("every other number to 555");
                break;
            case 3:
                changeTo444(array);
                System.out.println("every third number to 444");
                break;
            default:
                System.out.println("invalid action");
                break;
        }

        System.out.println("modified Array: " + Arrays.toString(array));
    }

    public static int generateRandomNumber(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }

    public static int[] generateRandomIntArray(int size) {
        int[] array = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(100);
        }
        return array;
    }

    public static void changeTo999(int[] array) {
        Arrays.fill(array, 999);
    }

    public static void changeTo555(int[] array) {
        for (int i = 1; i < array.length; i += 2) {
            array[i] = 555;
        }
    }

    public static void changeTo444(int[] array) {
        for (int i = 2; i < array.length; i += 3) {
            array[i] = 444;
        }
    }
}

