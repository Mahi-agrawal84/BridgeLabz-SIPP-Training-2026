import java.util.Scanner;

public class CoffeeCounter {
    public static void main(String[] args) {
        final double GST_RATE = 0.18; // 18% GST

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.print("Enter coffee type (Espresso, Latte, Cappuccino) or 'exit' to quit: ");
                String coffeeType = sc.nextLine();

                if (coffeeType.equalsIgnoreCase("exit")) {
                    System.out.println("Cafe closed. Thank you!");
                    break;
                }

                double price;

                price = switch (coffeeType.toLowerCase()) {
                    case "espresso" -> 120;
                    case "latte" -> 150;
                    case "cappuccino" -> 180;
                    default -> {
                        System.out.println("Invalid coffee type!");
                        yield -1;
                    }
                };

                if (price == -1) {
                    continue;
                }

                System.out.print("Enter quantity: ");
                int quantity = sc.nextInt();
                sc.nextLine(); // consume newline

                double bill = price * quantity;
                double gst = bill * GST_RATE;
                double totalBill = bill + gst;

                System.out.println("\n Bill");
                System.out.println("Coffee Type : " + coffeeType);
                System.out.println("Quantity    : " + quantity);
                System.out.println("Base Amount : ₹" + bill);
                System.out.println("GST (18%)   : ₹" + gst);
                System.out.println("Total Bill  : ₹" + totalBill);
                System.out.println("\n");
            }
        }
    }
}