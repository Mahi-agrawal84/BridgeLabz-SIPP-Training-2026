import java.util.Scanner;

public class RestaurantBilling {

    // Method to calculate food cost
    public static double calculateFoodCost(double price, int quantity) {
        return price * quantity;
    }

    // Method to calculate GST (5%)
    public static double calculateGST(double foodCost) {
        return foodCost * 0.05;
    }

    // Method to calculate discount (10% if bill > 1000)
    public static double calculateDiscount(double foodCost) {
        if (foodCost > 1000) {
            return foodCost * 0.10;
        }
        return 0;
    }

    // Method to generate final bill
    public static double generateFinalBill(double foodCost, double gst, double discount) {
        return foodCost + gst - discount;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            // Accept order details
            System.out.print("Enter Food Item Name: ");
            String itemName = sc.nextLine();

            System.out.print("Enter Price per Item: ");
            double price = sc.nextDouble();

            System.out.print("Enter Quantity: ");
            int quantity = sc.nextInt();

            // Call methods
            double foodCost = calculateFoodCost(price, quantity);
            double gst = calculateGST(foodCost);
            double discount = calculateDiscount(foodCost);
            double finalBill = generateFinalBill(foodCost, gst, discount);

            // Display bill
            System.out.println("\n RESTAURANT BILL");
            System.out.println("Item Name      : " + itemName);
            System.out.println("Price per Item : ₹" + price);
            System.out.println("Quantity       : " + quantity);
            System.out.println("Food Cost      : ₹" + foodCost);
            System.out.println("GST (5%)       : ₹" + gst);
            System.out.println("Discount       : ₹" + discount);
            System.out.println("");
            System.out.println("Final Payable  : ₹" + finalBill);
            System.out.println("");
        }
    }
}