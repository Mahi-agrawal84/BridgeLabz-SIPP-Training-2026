import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProductInventoryChecker {
    public static void main(String[] args) {

        String fileName = "inventory.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {

                // Split product name and quantity
                String[] data = line.split("-");

                if (data.length == 2) {
                    String productName = data[0];
                    int quantity = Integer.parseInt(data[1]);

                    // Check for out-of-stock items
                    if (quantity == 0) {
                        System.out.println(productName + " is out of stock");
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid quantity format in file.");
        }
    }
}