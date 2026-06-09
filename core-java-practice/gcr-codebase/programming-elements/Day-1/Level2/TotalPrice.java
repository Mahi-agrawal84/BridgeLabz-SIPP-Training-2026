package Level2;
import java.util.Scanner;

public class TotalPrice {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            double unitPrice = sc.nextDouble();
            int quantity = sc.nextInt();
            double total = unitPrice * quantity;
            System.out.println("The total purchase price is INR " + total + " if the quantity " + quantity + " and unit price is INR " + unitPrice);
        }
    }
}

