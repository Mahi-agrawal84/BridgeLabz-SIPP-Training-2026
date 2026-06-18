import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GroceryBillReader {
    public static void main(String[] args) {
        String fileName = "bill.txt";
        int lineCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            System.out.println("Contents of bill.txt:");
            System.out.println("");

            // Read and display each line
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                lineCount++;
            }

            // Display total number of lines
            System.out.println("");
            System.out.println("Total number of lines: " + lineCount);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}