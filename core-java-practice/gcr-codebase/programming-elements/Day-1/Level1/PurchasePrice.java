package Level1;
import java.util.Scanner;

public class PurchasePrice {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter unit price of the item (INR): ");
            double unitPrice = input.nextDouble();
            
            System.out.print("Enter quantity to be bought: ");
            int quantity = input.nextInt();
            
            double totalPrice = unitPrice * quantity;
            
            System.out.println("The total purchase price is INR " + totalPrice + " if the quantity " + quantity + " and unit price is INR " + unitPrice);
        }
    }
}

