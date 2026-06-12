import java.util.Scanner;

public class ParkingLotGateSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int capacity = 10; // Total parking slots
        int occupied = 0;
        int choice;

        while (true) {
            // Check if parking lot is full
            if (occupied == capacity) {
                System.out.println("\n Parking Lot is FULL!");
                System.out.println("Only Exit and Show Occupancy options are available.");
            }

            System.out.println("\n SMART PARKING SYSTEM ");
            System.out.println("1. Park Vehicle");
            System.out.println("2. Exit Vehicle");
            System.out.println("3. Show Occupancy");
            System.out.println("4. Exit System");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    if (occupied < capacity) {
                        occupied++;
                        System.out.println("Vehicle Parked Successfully.");
                        System.out.println("Occupied Slots: " + occupied);
                    } else {
                        System.out.println("Parking Lot is Full! Cannot Park More Vehicles.");
                    }
                }

                case 2 -> {
                    if (occupied > 0) {
                        occupied--;
                        System.out.println("Vehicle Exited Successfully.");
                        System.out.println("Occupied Slots: " + occupied);
                    } else {
                        System.out.println("Parking Lot is Empty!");
                    }
                }

                case 3 -> {
                    System.out.println("Total Capacity : " + capacity);
                    System.out.println("Occupied Slots : " + occupied);
                    System.out.println("Available Slots: " + (capacity - occupied));
                }

                case 4 -> {
                    System.out.println("Exiting Parking System...");
                    sc.close();
                    return;
                }

                default -> System.out.println("Invalid Choice! Please Try Again.");
            }

            // Optional: Stop automatically if full
            if (occupied == capacity) {
                System.out.println("\nParking Lot has reached maximum capacity.");
            }
        }
    }
}