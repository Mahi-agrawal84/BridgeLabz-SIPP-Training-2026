import java.util.ArrayList;
import java.util.Scanner;

public class SmartParkingSlotManager {

    // ArrayList to store parked vehicles
    private final ArrayList<String> parkedVehicles = new ArrayList<>();

    // Add vehicle
    public void addVehicle(String regNo) {
        if (parkedVehicles.contains(regNo)) {
            System.out.println("Vehicle is already parked.");
        } else {
            parkedVehicles.add(regNo);
            System.out.println("Vehicle entered parking successfully.");
        }
    }

    // Remove vehicle
    public void removeVehicle(String regNo) {
        if (parkedVehicles.remove(regNo)) {
            System.out.println("Vehicle exited parking successfully.");
        } else {
            System.out.println("Vehicle not found in parking.");
        }
    }

    // Search vehicle
    public void searchVehicle(String regNo) {
        if (parkedVehicles.contains(regNo)) {
            System.out.println("Vehicle " + regNo + " is currently parked.");
        } else {
            System.out.println("Vehicle " + regNo + " is NOT parked.");
        }
    }

    // Display all parked vehicles
    public void displayVehicles() {
        if (parkedVehicles.isEmpty()) {
            System.out.println("Parking area is empty.");
        } else {
            System.out.println("\nParked Vehicles:");
            for (String vehicle : parkedVehicles) {
                System.out.println(vehicle);
            }
            System.out.println("Total Occupied Parking Slots: " + parkedVehicles.size());
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            SmartParkingSlotManager manager = new SmartParkingSlotManager();

            int choice;

            do {
                System.out.println("\n===== Smart Parking Slot Manager =====");
                System.out.println("1. Vehicle Entry");
                System.out.println("2. Vehicle Exit");
                System.out.println("3. Search Vehicle");
                System.out.println("4. Display Parked Vehicles");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                choice = sc.nextInt();
                sc.nextLine(); // Consume newline

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter Vehicle Registration Number: ");
                        String regNo = sc.nextLine();
                        manager.addVehicle(regNo);
                    }
                    case 2 -> {
                        System.out.print("Enter Vehicle Registration Number: ");
                        String regNo = sc.nextLine();
                        manager.removeVehicle(regNo);
                    }
                    case 3 -> {
                        System.out.print("Enter Vehicle Registration Number: ");
                        String regNo = sc.nextLine();
                        manager.searchVehicle(regNo);
                    }
                    case 4 -> manager.displayVehicles();
                    case 5 -> System.out.println("Thank you! Exiting...");
                    default -> System.out.println("Invalid choice! Please try again.");
                }

            } while (choice != 5);
        }
    }
}