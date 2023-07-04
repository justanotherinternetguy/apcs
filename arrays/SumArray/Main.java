import java.io.*;
import java.util.*;

// TODO: filled

public class Main {
  public static void main (String[] args) {
    // int arr[][] = {{1, 3, 5}, {3, 5, 7}, {8, 9, 1}};
    Scanner sc = new Scanner(System.in);
    System.out.println("INT ====================");

    int intArr[][] = new int[5][4];
    out:
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 4; j++) {
        System.out.print(">> ");
        String tmp = sc.next();

        if (tmp.equals("END")) {
          break out;
        }
        else {
          intArr[i][j] = Integer.parseInt(tmp);
        }
      }
    }

    display(intArr);
    sumArray(intArr, 20);


    System.out.println("DOUBLE ====================");
    double doubleArr[][] = new double[5][4];
    out:
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 4; j++) {
        System.out.print(">> ");
        String tmp = sc.next();

        if (tmp.equals("END")) {
          break out;
        }
        else {
          doubleArr[i][j] = Double.parseDouble(tmp);
        }
      }
    }

    display(doubleArr);
    sumArray(doubleArr, 20);
  }
  
  static void sumArray(int[][] arr, int filled) {
    int[] rowSums = new int[arr.length];
    
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        rowSums[i] += arr[i][j];
      }
    }

    int sum = 0;
    for (int i : rowSums) {
      sum += i;
    }

    System.out.println("SUM = " + sum);
    System.out.println("AVG = " + (double)(sum/Double.valueOf(filled)));
  }

  static void sumArray(double[][] arr, int filled) {
    double[] rowSums = new double[arr.length];
    
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        rowSums[i] += arr[i][j];
      }
    }

    double sum = 0;
    for (double i : rowSums) {
      sum += i;
    }

    System.out.println("SUM = " + sum);
    System.out.println("AVG = " + (double)(sum/Double.valueOf(filled)));
  }

  static void display(int[][] arr) {
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 4; j++) {
        System.out.print(arr[i][j]);
      }
      System.out.println();
    }
  }

  static void display(double[][] arr) {
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 4; j++) {
        System.out.print(arr[i][j]);
      }
      System.out.println();
    }
  }
}
