import java.util.Scanner;

public class RajResultGenerator {
    public static void main(String[] args) {
        int[] marks = new int[5];
        int total = 0;

        try (Scanner sc = new Scanner(System.in)) {
            // Input marks using for loop
            System.out.println("Enter marks for 5 subjects:");
            for (int i = 0; i < 5; i++) {
                System.out.print("Subject " + (i + 1) + ": ");
                marks[i] = sc.nextInt();
                total += marks[i];
            }

            // Calculate average
            double average = total / 5.0;

            // Determine grade category for switch
            int gradeCategory;
            if (average >= 90)
                gradeCategory = 1;
            else if (average >= 80)
                gradeCategory = 2;
            else if (average >= 70)
                gradeCategory = 3;
            else if (average >= 60)
                gradeCategory = 4;
            else
                gradeCategory = 5;

            // Assign grade using switch expression
            String grade = switch (gradeCategory) {
                case 1 -> "A+";
                case 2 -> "A";
                case 3 -> "B";
                case 4 -> "C";
                default -> "F";
            };

            // Display result
            System.out.println("\n Result:");
            System.out.println("Total Marks = " + total);
            System.out.println("Average Marks = " + average);
            System.out.println("Grade = " + grade);
        }
    }
}