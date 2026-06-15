import java.util.Scanner;

public class DeliveryChargeSystem {

    // Method 1: Charge based on distance only
    public static double calculateCharge(int distance) {
        return distance * 5.0;
    }

    // Method 2: Charge based on distance and weight
    public static double calculateCharge(int distance, int weight) {
        return (distance * 5.0) + (weight * 10.0);
    }

    // Method 3: Charge based on distance, weight, and express delivery
    public static double calculateCharge(int distance, int weight, boolean expressDelivery) {
        double charge = (distance * 5.0) + (weight * 10.0);

        if (expressDelivery) {
            charge += 100; // Express delivery charge
        }

        return charge;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println(" Delivery Charge System");
            System.out.print("Enter Distance (km): ");
            int distance = sc.nextInt();

            System.out.print("Enter Weight (kg): ");
            int weight = sc.nextInt();

            System.out.print("Express Delivery? (true/false): ");
            boolean express = sc.nextBoolean();

            // Calling overloaded methods
            double charge1 = calculateCharge(distance);
            double charge2 = calculateCharge(distance, weight);
            double charge3 = calculateCharge(distance, weight, express);

            System.out.println("\n Delivery Charges ");
            System.out.println("Distance Only: ₹" + charge1);
            System.out.println("Distance + Weight: ₹" + charge2);
            System.out.println("Distance + Weight + Express: ₹" + charge3);
        }
    }
}