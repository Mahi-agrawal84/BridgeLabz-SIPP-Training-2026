import java.util.Scanner;

public class BubbleSortStudentMarks {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter number of students: ");
            int n = sc.nextInt();

            int[] marks = new int[n];

            System.out.println("Enter student marks:");
            for (int i = 0; i < n; i++) {
                marks[i] = sc.nextInt();
            }

            boolean swapped;

            for (int i = 0; i < n - 1; i++) {
                swapped = false;

                for (int j = 0; j < n - i - 1; j++) {
                    if (marks[j] > marks[j + 1]) {
                        int temp = marks[j];
                        marks[j] = marks[j + 1];
                        marks[j + 1] = temp;
                        swapped = true;
                    }
                }

                if (!swapped) {
                    break;
                }
            }

            System.out.println("Marks in Ascending Order:");
            for (int mark : marks) {
                System.out.print(mark + " ");
            }
        }
    }
}