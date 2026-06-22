class WaterBottle {

    // Instance Variables
    String ownerName;
    int dailyTarget;

    // Constructor
    WaterBottle(String ownerName, int dailyTarget) {
        this.ownerName = ownerName;
        this.dailyTarget = dailyTarget;
    }

    // Method to display bottle information
    void displayBottleInfo() {
        System.out.println("Owner Name  : " + ownerName);
        System.out.println("Daily Target: " + dailyTarget + " ml");
        System.out.println(" ");
    }
}

public class WaterBottleTracker {

    public static void main(String[] args) {

        // Create two WaterBottle objects
        WaterBottle bottle1 = new WaterBottle("Aman", 3000);
        WaterBottle bottle2 = new WaterBottle("Priya", 2500);

        // Display information
        bottle1.displayBottleInfo();
        bottle2.displayBottleInfo();
    }
}