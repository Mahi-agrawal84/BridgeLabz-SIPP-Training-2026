import java.util.Scanner;

// Custom Exception
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class HospitalBillingSystem {

    // Method to process payment
    public static void processPayment(double billAmount, double paymentAmount)
            throws InsufficientFundsException {

        if (paymentAmount < billAmount) {
            throw new InsufficientFundsException(
                    "Payment failed: Insufficient funds. Required ₹" + billAmount +
                    ", Available ₹" + paymentAmount);
        }

        System.out.println("Payment successful!");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Sample patient bills
        double[] patientBills = {2500, 4000, 3200, 1800};

        try {
            // NumberFormatException Handling
            System.out.print("Enter number of items in bill: ");
            String itemInput = sc.nextLine();
            int items = Integer.parseInt(itemInput);

            System.out.print("Enter total bill amount: ");
            String billInput = sc.nextLine();
            double totalBill = Double.parseDouble(billInput);

            // Division by Zero Handling
            double averageCost = totalBill / items;
            System.out.println("Average cost per item: ₹" + averageCost);

            // ArrayIndexOutOfBoundsException Handling
            System.out.print("Enter patient index (0-3): ");
            int index = Integer.parseInt(sc.nextLine());

            System.out.println("Patient Bill: ₹" + patientBills[index]);

            // Custom Exception Handling
            System.out.print("Enter payment amount: ");
            double payment = Double.parseDouble(sc.nextLine());

            processPayment(patientBills[index], payment);

        } catch (ArithmeticException e) {
            System.out.println("Error: Bill cannot have zero items.");

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid patient index entered.");

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format. Please enter valid numeric values.");

        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());

        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());

        } finally {
            System.out.println("Hospital billing process completed.");
            sc.close();
        }
    }
}