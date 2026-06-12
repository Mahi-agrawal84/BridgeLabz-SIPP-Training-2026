import java.util.Scanner;

public class MetroSmartCard {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter initial smart card balance: ");
            double balance = sc.nextDouble();

            while (balance > 0) {
                System.out.print("\nEnter distance traveled (in km): ");
                double distance = sc.nextDouble();

                // Fare calculation using nested ternary operator
                double fare = (distance <= 5) ? 10 :
                              (distance <= 15) ? 20 :
                              (distance <= 30) ? 30 : 40;

                System.out.println("Fare: ₹" + fare);

                if (balance >= fare) {
                    balance -= fare;
                    System.out.println("Fare deducted successfully.");
                    System.out.println("Remaining Balance: ₹" + balance);
                } else {
                    System.out.println("Insufficient balance!");
                    break;
                }

                System.out.print("Press 'Q' to quit or any other key to continue: ");
                String choice = sc.next();

                if (choice.equalsIgnoreCase("Q")) {
                    System.out.println("Thank you for using Delhi Metro Smart Card.");
                    break;
                }
            }

            if (balance <= 0) {
                System.out.println("Smart card balance exhausted.");
            }
        }
    }
}