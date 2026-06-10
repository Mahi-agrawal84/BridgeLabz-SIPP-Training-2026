package Level2;
import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int number = sc.nextInt();
        double[][] marks = new double[number][3];
        double[] percentage = new double[number];
        String[] grade = new String[number];
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < 3; j++) {
                while (true) {
                    if (j == 0) System.out.print("Enter Physics marks of student " + (i + 1) + ": ");
                    else if (j == 1) System.out.print("Enter Chemistry marks of student " + (i + 1) + ": ");
                    else System.out.print("Enter Maths marks of student " + (i + 1) + ": ");
                    double m = sc.nextDouble();
                    if (m >= 0 && m <= 100) {
                        marks[i][j] = m;
                        break;
                    } else {
                        System.out.println("Enter valid marks between 0 and 100.");
                    }
                }
            }
        }
        for (int i = 0; i < number; i++) {
            double total = marks[i][0] + marks[i][1] + marks[i][2];
            percentage[i] = total / 3.0;
            if (percentage[i] >= 90) grade[i] = "A";
            else if (percentage[i] >= 75) grade[i] = "B";
            else if (percentage[i] >= 50) grade[i] = "C";
            else grade[i] = "D";
        }
        System.out.println("Result of Students:");
        for (int i = 0; i < number; i++) {
            System.out.println("Student " + (i + 1) + " -> Physics: " + marks[i][0] + ", Chemistry: " + marks[i][1] + ", Maths: " + marks[i][2] + ", Percentage: " + percentage[i] + ", Grade: " + grade[i]);
        }
    }
}

