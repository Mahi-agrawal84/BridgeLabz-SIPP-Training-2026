class Vehicle {
    String vehicleNumber;
    String ownerName;
    String vehicleType;

    // Constructor using this keyword
    Vehicle(String vehicleNumber, String ownerName, String vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Display vehicle details
    void displayDetails() {
        System.out.println("Vehicle Number : " + vehicleNumber);
        System.out.println("Owner Name     : " + ownerName);
        System.out.println("Vehicle Type   : " + vehicleType);
        System.out.println("");
    }
}

public class SmartParkingManagement {

    // Display all Cars
    static void displayCars(Vehicle[] vehicles) {
        System.out.println("\n PARKED CARS ");

        for (Vehicle vehicle : vehicles) {
            if (vehicle != null &&
                vehicle.vehicleType.equalsIgnoreCase("Car")) {
                vehicle.displayDetails();
            }
        }
    }

    // Display all Bikes
    static void displayBikes(Vehicle[] vehicles) {
        System.out.println("\n PARKED BIKES ");

        for (Vehicle vehicle : vehicles) {
            if (vehicle != null &&
                vehicle.vehicleType.equalsIgnoreCase("Bike")) {
                vehicle.displayDetails();
            }
        }
    }

    public static void main(String[] args) {

        Vehicle[] vehicles = new Vehicle[10];

        vehicles[0] = new Vehicle("UP81AB1234", "Aman", "Car");
        vehicles[1] = new Vehicle("UP81CD5678", "Priya", "Bike");
        vehicles[2] = new Vehicle("UP81EF1111", "Rahul", "Car");
        vehicles[3] = new Vehicle("UP81GH2222", "Neha", "Bike");
        vehicles[4] = new Vehicle("UP81IJ3333", "Rohit", "Car");
        vehicles[5] = new Vehicle("UP81KL4444", "Anjali", "Bike");
        vehicles[6] = new Vehicle("UP81MN5555", "Vikas", "Car");
        vehicles[7] = new Vehicle("UP81OP6666", "Pooja", "Bike");
        vehicles[8] = new Vehicle("UP81QR7777", "Karan", "Car");
        vehicles[9] = new Vehicle("UP81ST8888", "Sneha", "Bike");

        displayCars(vehicles);
        displayBikes(vehicles);
    }
}