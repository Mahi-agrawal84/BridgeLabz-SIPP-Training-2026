package Level2;
import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        double[] physicsMarks = new double[n];
        double[] chemistryMarks = new double[n];
        double[] mathMarks = new double[n];
        double[] percentages = new double[n];
        String[] grades = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter physics marks for student " + (i + 1) + ": ");
            physicsMarks[i] = scanner.nextDouble();
            System.out.print("Enter chemistry marks for student " + (i + 1) + ": ");
            chemistryMarks[i] = scanner.nextDouble();
            System.out.print("Enter math marks for student " + (i + 1) + ": ");
            mathMarks[i] = scanner.nextDouble();

            if (physicsMarks[i] < 0) physicsMarks[i] = Math.abs(physicsMarks[i]);
            if (chemistryMarks[i] < 0) chemistryMarks[i] = Math.abs(chemistryMarks[i]);
            if (mathMarks[i] < 0) mathMarks[i] = Math.abs(mathMarks[i]);

            double totalMarks = physicsMarks[i] + chemistryMarks[i] + mathMarks[i];
            percentages[i] = (totalMarks / 300) * 100;

            if (percentages[i] >= 80) {
                grades[i] = "A";
            } else if (percentages[i] >= 70) {
                grades[i] = "B";
            } else if (percentages[i] >= 60) {
                grades[i] = "C";
            } else if (percentages[i] >= 50) {
                grades[i] = "D";
            } else if (percentages[i] >= 40) {
                grades[i] = "E";
            } else {
                grades[i] = "R";
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + ": ");
            System.out.println("Physics Marks: " + physicsMarks[i]);
            System.out.println("Chemistry Marks: " + chemistryMarks[i]);
            System.out.println("Math Marks: " + mathMarks[i]);
            System.out.println("Percentage: " + percentages[i]);
            System.out.println("Grade: " + grades[i]);
            System.out.println();
        }

        scanner.close();
    }
}
