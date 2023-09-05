import java.io.*;
import java.util.Arrays;

public class StudentGrades {
    public static void main(String[] args) {
        // Constants
        final int MAX_STUDENTS = 25;
        String[] studentNames = new String[MAX_STUDENTS];
        double[][] studentGrades = new double[MAX_STUDENTS][5];
        double[] studentAverages = new double[MAX_STUDENTS];

        try {
            // Read data from the file
            BufferedReader br = new BufferedReader(new FileReader("grades.txt"));
            String line;
            int studentCount = 0;

            while ((line = br.readLine()) != null && studentCount < MAX_STUDENTS) {
                String[] parts = line.split(" ");
                studentNames[studentCount] = parts[0];
                for (int i = 0; i < 5; i++) {
                    studentGrades[studentCount][i] = Double.parseDouble(parts[i + 1]);
                }
                studentCount++;
            }
            br.close();

            // Calculate the average grade for each student
            for (int i = 0; i < studentCount; i++) {
                double sum = 0;
                for (int j = 0; j < 5; j++) {
                    sum += studentGrades[i][j];
                }
                studentAverages[i] = sum / 5;
            }

            // Sort the averages using bubble sort
            bubbleSort(studentNames, studentAverages, studentCount);

            // Display the sorted students and their averages
            System.out.println("Sorted by Averages (Bubble Sort):");
            for (int i = 0; i < studentCount; i++) {
                System.out.println(studentNames[i] + " " + studentAverages[i]);
            }

            // Sort the averages using Java's Arrays.sort method
            Arrays.sort(studentAverages, 0, studentCount);
            
            // Display the sorted students and their averages
            System.out.println("\nSorted by Averages (Arrays.sort):");
            for (int i = 0; i < studentCount; i++) {
                for (int j = 0; j < studentCount; j++) {
                    if (studentAverages[i] == (getAverage(studentGrades[j]))) {
                        System.out.println(studentNames[j] + " " + studentAverages[i]);
                        break;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Bubble Sort implementation
    private static void bubbleSort(String[] names, double[] averages, int n) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (averages[i] > averages[i + 1]) {
                    // Swap averages
                    double tempAverage = averages[i];
                    averages[i] = averages[i + 1];
                    averages[i + 1] = tempAverage;

                    // Swap names
                    String tempName = names[i];
                    names[i] = names[i + 1];
                    names[i + 1] = tempName;

                    swapped = true;
                }
            }
        } while (swapped);
    }

    // Calculate the average grade for a student
    private static double getAverage(double[] grades) {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.length;
    }
}

