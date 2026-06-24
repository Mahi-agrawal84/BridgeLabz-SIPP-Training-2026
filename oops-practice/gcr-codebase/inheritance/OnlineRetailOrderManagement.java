// Base Class
class Order {
    protected int orderId;
    protected String orderDate;

    public Order(int orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return "Order Placed";
    }
}

// Subclass
class ShippedOrder extends Order {
    protected String trackingNumber;

    public ShippedOrder(int orderId, String orderDate,
                        String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    public String getOrderStatus() {
        return "Order Shipped";
    }
}

// Subclass of ShippedOrder
class DeliveredOrder extends ShippedOrder {
    private final String deliveryDate;

    public DeliveredOrder(int orderId, String orderDate,
                          String trackingNumber,
                          String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String getOrderStatus() {
        return "Order Delivered";
    }

    public void displayDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Tracking Number: " + trackingNumber);
        System.out.println("Delivery Date: " + deliveryDate);
        System.out.println("Status: " + getOrderStatus());
    }
}

// Main Class
public class OnlineRetailOrderManagement {
    public static void main(String[] args) {

        Order order = new Order(101, "20-06-2026");
        ShippedOrder shippedOrder =
                new ShippedOrder(102, "21-06-2026", "TRK12345");
        DeliveredOrder deliveredOrder =
                new DeliveredOrder(103, "22-06-2026",
                        "TRK67890", "24-06-2026");

        System.out.println("Order Status: "
                + order.getOrderStatus());

        System.out.println("Shipped Order Status: "
                + shippedOrder.getOrderStatus());

        System.out.println("\nDelivered Order Details:");
        deliveredOrder.displayDetails();
    }
}