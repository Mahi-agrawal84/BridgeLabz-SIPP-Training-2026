class Drone {

    // Instance Variables
    private final String droneId;
    private int batteryPercentage;

    // Static Variable
    static String companyName = "SkyLogistics Pvt Ltd";

    // Constructor using 'this' keyword
    public Drone(String droneId, int batteryPercentage) {
        this.droneId = droneId;
        this.batteryPercentage = batteryPercentage;
    }

    // Method to start delivery
    public void startDelivery() {
        if (batteryPercentage >= 20) {
            System.out.println("Drone " + droneId + " has started delivery.");
            batteryPercentage -= 10; // Battery consumed
        } else {
            System.out.println("Drone " + droneId +
                    " cannot start delivery. Battery too low!");
        }
    }

    // Method to display status
    public void displayStatus() {
        System.out.println("\nCompany Name      : " + companyName);
        System.out.println("Drone ID          : " + droneId);
        System.out.println("Battery Percentage: " + batteryPercentage + "%");
    }
}

public class DroneDeliverySystem {

    public static void main(String[] args) {

        // Creating multiple drones
        Drone d1 = new Drone("D101", 80);
        Drone d2 = new Drone("D102", 50);
        Drone d3 = new Drone("D103", 15);

        // Start deliveries
        d1.startDelivery();
        d2.startDelivery();
        d3.startDelivery();

        // Display status of all drones
        d1.displayStatus();
        d2.displayStatus();
        d3.displayStatus();

        // Verify static variable is shared
        System.out.println("\nChanging company name...\n");
        Drone.companyName = "QuickFly Logistics";

        d1.displayStatus();
        d2.displayStatus();
        d3.displayStatus();
    }
}