import java.util.Scanner;

public class InsertionSortEmployeeIDs {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter number of employees: ");
            int n = sc.nextInt();

            int[] empIds = new int[n];

            System.out.println("Enter Employee IDs:");
            for (int i = 0; i < n; i++) {
                empIds[i] = sc.nextInt();
            }

            for (int i = 1; i < n; i++) {
                int key = empIds[i];
                int j = i - 1;

                while (j >= 0 && empIds[j] > key) {
                    empIds[j + 1] = empIds[j];
                    j--;
                }

                empIds[j + 1] = key;
            }

            System.out.println("Employee IDs in Ascending Order:");
            for (int id : empIds) {
                System.out.print(id + " ");
            }
        }
    }
}