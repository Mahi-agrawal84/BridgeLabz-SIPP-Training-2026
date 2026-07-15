import java.util.Scanner;

public class WarehouseStockRecoverySystem {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            // Accept number of products
            System.out.print("Enter number of products: ");
            int n = sc.nextInt();

            int[] stock = new int[n];

            // Accept stock quantities
            System.out.println("Enter stock quantities:");
            for (int i = 0; i < n; i++) {
                stock[i] = sc.nextInt();
            }

            int zeroPosition = -1;
            int sum = 0;
            int count = 0;

            // Find position of 0 and calculate average of non-zero stocks
            for (int i = 0; i < n; i++) {
                if (stock[i] == 0) {
                    zeroPosition = i;
                } else {
                    sum += stock[i];
                    count++;
                }
            }

            // Calculate average stock
            int averageStock = sum / count;

            // Replace missing stock with average
            if (zeroPosition != -1) {
                stock[zeroPosition] = averageStock;
            }

            // Display results
            System.out.println("\nMissing stock found at position: " + (zeroPosition + 1));
            System.out.println("Average stock of non-zero products: " + averageStock);

            System.out.println("\nUpdated Inventory:");
            for (int i = 0; i < n; i++) {
                System.out.println("Product " + (i + 1) + ": " + stock[i]);
            }
        }
    }
}