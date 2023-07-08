class Student {
  String name;
  double[] grades;
  double averageGrade;

  Student(String name, double[] grades) {
    this.name = name;
    this.grades = grades;
  }

  double getAverageGrade() {
    double sum = 0;
    for (int i = 0; i < grades.length; i++) {
      sum += grades[i];
    }
    return sum/grades.length;
  }
}

public class Main {
  public static void main(String[] args) {
  }
}
