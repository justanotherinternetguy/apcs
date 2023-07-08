import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    String in = "";
    Scanner sc = new Scanner(System.in);
    System.out.print("size >> ");
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      System.out.print("enter >> ");
      in = sc.next();
      arr[i] = Integer.parseInt(in);
    }
    reverseArray(arr);
    printArray(arr);
  }

  public static void reverseArray(int[] arr) {
    int start = 0;
    int end = arr.length - 1;

    while (start < end) {
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;

      start++;
      end--;
    }
  }

  public static void printArray(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }
}