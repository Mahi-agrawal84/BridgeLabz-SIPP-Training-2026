import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DailyExpenseLogger {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in);
             FileWriter writer = new FileWriter("expenses.txt", true)) {

            System.out.print("Enter Expense Category: ");
            String category = sc.nextLine();

            System.out.print("Enter Expense Amount: ");
            double amount = sc.nextDouble();

            // Store in required format
            writer.write(category + " - " + amount + "\n");

            System.out.println("Expense saved successfully!");

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}