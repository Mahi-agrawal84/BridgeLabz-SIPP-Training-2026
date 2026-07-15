// Interface 1
interface FoodDelivery {

    void deliverFood(String customerName);

    default void trackOrder() {
        System.out.println("Food order is being tracked.");
    }

    static String generateDeliveryCode() {
        return "FD" + (int)(Math.random() * 10000);
    }
}

// Interface 2
interface GroceryDelivery {

    void deliverGroceries(String customerName);

    default void trackOrder() {
        System.out.println("Grocery order is being tracked.");
    }
}

// Class implementing both interfaces
class DeliveryExecutive implements FoodDelivery, GroceryDelivery {

    @Override
    public void deliverFood(String customerName) {
        System.out.println("Food delivered to " + customerName);
    }

    @Override
    public void deliverGroceries(String customerName) {
        System.out.println("Groceries delivered to " + customerName);
    }

    // Resolve default method conflict
    @Override
    public void trackOrder() {
        FoodDelivery.super.trackOrder();
        GroceryDelivery.super.trackOrder();
    }

    public void processDelivery(String customerName) {

        String deliveryCode =
                FoodDelivery.generateDeliveryCode();

        System.out.println("\nCustomer: " + customerName);
        System.out.println("Delivery Code: " + deliveryCode);

        trackOrder();
        deliverFood(customerName);
        deliverGroceries(customerName);
    }
}

// Main Class
public class FoodDeliveryPartnerSystem {

    public static void main(String[] args) {

        String[] customers = {
                "Mahi",
                "Rahul",
                "Priya",
                "Aman"
        };

        DeliveryExecutive executive =
                new DeliveryExecutive();

        System.out.println(" DELIVERY REPORT ");

        for (String customer : customers) {
            executive.processDelivery(customer);
        }
    }
}