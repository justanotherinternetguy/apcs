import java.io.*;
import java.util.*;

public class SortComparison {
    public static void main(String[] args) {
        int[] array1 = loadArrayFromFile("array1.txt");
        int[] array2 = loadArrayFromFile("array2.txt");
        int[] array3 = loadArrayFromFile("array3.txt");

        long bubbleSortTime1 = timeBubbleSort(array1.clone());
        long javaSortTime1 = timeJavaSort(array1.clone());

        long bubbleSortTime2 = timeBubbleSort(array2.clone());
        long javaSortTime2 = timeJavaSort(array2.clone());

        long bubbleSortTime3 = timeBubbleSort(array3.clone());
        long javaSortTime3 = timeJavaSort(array3.clone());

        compareSortTimes("Array 1", bubbleSortTime1, javaSortTime1);
        compareSortTimes("Array 2", bubbleSortTime2, javaSortTime2);
        compareSortTimes("Array 3", bubbleSortTime3, javaSortTime3);
    }

    private static int[] loadArrayFromFile(String filename) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            List<Integer> list = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                list.add(Integer.parseInt(line));
            }
            br.close();
            return list.stream().mapToInt(Integer::intValue).toArray();
        } catch (IOException e) {
            e.printStackTrace();
            return new int[0];
        }
    }

    private static long timeBubbleSort(int[] array) {
        long start = System.currentTimeMillis();
        bubbleSort(array);
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1] > arr[i]) {
                    int temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }

    private static long timeJavaSort(int[] array) {
        long start = System.currentTimeMillis();
        Arrays.sort(array);
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static void compareSortTimes(String arrayName, long bubbleSortTime, long javaSortTime) {
        System.out.println(arrayName + " Sorting Comparison:");
        System.out.println("Bubble Sort Time: " + bubbleSortTime + " ms");
        System.out.println("Java Arrays.sort() Time: " + javaSortTime + " ms");
        if (bubbleSortTime < javaSortTime) {
            System.out.println("Bubble Sort was faster.");
        } else if (bubbleSortTime > javaSortTime) {
            System.out.println("Java Arrays.sort() was faster.");
        } else {
            System.out.println("Both sorting methods took the same amount of time.");
        }
        System.out.println();
    }
}

