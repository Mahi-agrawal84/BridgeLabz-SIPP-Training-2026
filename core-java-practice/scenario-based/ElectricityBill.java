import java.util.Scanner;

public class ElectricityBill {

    String customerName;
    int units;
    double billAmount;

    // Method to accept customer details and units consumed
    public void acceptDetails() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter Customer Name: ");
            customerName = sc.nextLine();

            System.out.print("Enter Units Consumed: ");
            units = sc.nextInt();
        }
    }

    // Method to calculate bill amount
    public void calculateBill() {
        if (units <= 100) {
            billAmount = units * 1.5;
        } else if (units <= 300) {
            billAmount = (100 * 1.5) + ((units - 100) * 2.5);
        } else {
            billAmount = (100 * 1.5) + (200 * 2.5) + ((units - 300) * 4.0);
        }
    }

    // Method to display bill details
    public void displayBill() {
        System.out.println("\nELECTRICITY BILL");
        System.out.println("Customer Name : " + customerName);
        System.out.println("Units Consumed: " + units);
        System.out.println("Bill Amount   : ₹" + billAmount);
        System.out.println("");
    }

    public static void main(String[] args) {
        ElectricityBill bill = new ElectricityBill();

        bill.acceptDetails();
        bill.calculateBill();
        bill.displayBill();
    }
}