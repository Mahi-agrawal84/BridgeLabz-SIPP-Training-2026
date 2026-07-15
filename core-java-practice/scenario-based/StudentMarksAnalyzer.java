import java.util.Scanner;

public class StudentMarksAnalyzer {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // Accept number of students
            System.out.print("Enter number of students: ");
            int n = sc.nextInt();

            int[] marks = new int[n];

            // Accept marks
            System.out.println("Enter marks of students:");
            for (int i = 0; i < n; i++) {
                System.out.print("Student " + (i + 1) + ": ");
                marks[i] = sc.nextInt();
            }

            int highest = marks[0];
            int lowest = marks[0];
            int countAbove75 = 0;
            int sum = 0;

            // Find highest, lowest, count above 75, and sum
            for (int i = 0; i < n; i++) {
                if (marks[i] > highest) {
                    highest = marks[i];
                }

                if (marks[i] < lowest) {
                    lowest = marks[i];
                }

                if (marks[i] > 75) {
                    countAbove75++;
                }

                sum += marks[i];
            }

            // Calculate average
            double average = (double) sum / n;

            // Display results
            System.out.println("\n Analysis Report ");
            System.out.println("Highest Marks: " + highest);
            System.out.println("Lowest Marks : " + lowest);
            System.out.println("Students Scoring Above 75: " + countAbove75);
            System.out.println("Average Marks: " + average);

            // Display marks greater than average
            System.out.print("Marks Greater Than Average: ");
            for (int i = 0; i < n; i++) {
                if (marks[i] > average) {
                    System.out.print(marks[i] + " ");
                }
            }
        }
    }
}