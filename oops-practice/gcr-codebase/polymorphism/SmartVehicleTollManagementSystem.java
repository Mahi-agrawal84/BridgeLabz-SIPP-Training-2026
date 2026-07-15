// Superclass
class Vehicle {
    String vehicleNumber;
    String ownerName;

    Vehicle(String vehicleNumber, String ownerName) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
    }

    double calculateToll() {
        return 0;
    }

    void displayDetails() {
        System.out.println("Vehicle Number : " + vehicleNumber);
        System.out.println("Owner Name     : " + ownerName);
    }
}

// Car Class
class Car extends Vehicle {

    Car(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    @Override
    double calculateToll() {
        return 100.0;
    }
}

// Bus Class
class Bus extends Vehicle {

    Bus(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    @Override
    double calculateToll() {
        return 250.0;
    }
}

// Truck Class
class Truck extends Vehicle {

    Truck(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    @Override
    double calculateToll() {
        return 400.0;
    }
}

public class SmartVehicleTollManagementSystem {

    // Calculate Total Revenue
    static double calculateTotalRevenue(Vehicle[] vehicles) {
        double totalRevenue = 0;

        for (Vehicle vehicle : vehicles) {
            totalRevenue += vehicle.calculateToll(); // Polymorphism
        }

        return totalRevenue;
    }

    // Search Vehicle by Number
    static void searchVehicle(Vehicle[] vehicles,
                              String vehicleNumber) {

        boolean found = false;

        for (Vehicle vehicle : vehicles) {

            if (vehicle.vehicleNumber.equalsIgnoreCase(vehicleNumber)) {

                System.out.println("\nVehicle Found:");
                vehicle.displayDetails();
                System.out.println("Toll Paid : ₹" +
                                   vehicle.calculateToll());

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("\nVehicle not found!");
        }
    }

    public static void main(String[] args) {

        Vehicle[] vehicles = {
                new Car("CAR101", "Mahi"),
                new Bus("BUS201", "Rahul"),
                new Truck("TRK301", "Anjali"),
                new Car("CAR102", "Aman"),
                new Truck("TRK302", "Priya")
        };

        System.out.println(" Vehicle Toll Details ");

        int carCount = 0;
        int busCount = 0;
        int truckCount = 0;

        Vehicle highestTollVehicle = vehicles[0];
        double highestToll = vehicles[0].calculateToll();

        for (Vehicle vehicle : vehicles) {

            vehicle.displayDetails();
            System.out.println("Toll Paid : ₹" +
                               vehicle.calculateToll());
            System.out.println(" ");

            // Count vehicle types
            if (vehicle instanceof Car) {
                carCount++;
            } else if (vehicle instanceof Bus) {
                busCount++;
            } else if (vehicle instanceof Truck) {
                truckCount++;
            }

            // Find highest toll vehicle
            if (vehicle.calculateToll() > highestToll) {
                highestToll = vehicle.calculateToll();
                highestTollVehicle = vehicle;
            }
        }

        // Total Revenue
        System.out.println("\nTotal Revenue Collected : ₹" +
                           calculateTotalRevenue(vehicles));

        // Highest Toll Vehicle
        System.out.println("\n Highest Toll Vehicle ");
        highestTollVehicle.displayDetails();
        System.out.println("Highest Toll Paid : ₹" +
                           highestToll);

        // Vehicle Counts
        System.out.println("\n Vehicle Count ");
        System.out.println("Cars   : " + carCount);
        System.out.println("Buses  : " + busCount);
        System.out.println("Trucks : " + truckCount);

        // Search Vehicle
        searchVehicle(vehicles, "TRK301");
    }
}