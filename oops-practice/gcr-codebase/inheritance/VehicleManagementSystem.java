// Interface
interface Refuelable {
    void refuel();
}

// Superclass
class Vehicle {
    protected int maxSpeed;
    protected String model;

    public Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public void displayVehicleInfo() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

// Subclass
class ElectricVehicle extends Vehicle {

    public ElectricVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }

    public void charge() {
        System.out.println(model + " is charging...");
    }
}

// Subclass implementing Interface
class PetrolVehicle extends Vehicle implements Refuelable {

    public PetrolVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }

    @Override
    public void refuel() {
        System.out.println(model + " is being refueled.");
    }
}

// Main Class
public class VehicleManagementSystem {
    public static void main(String[] args) {

        ElectricVehicle ev =
                new ElectricVehicle("Tesla Model 3", 225);

        PetrolVehicle pv =
                new PetrolVehicle("Honda City", 180);

        System.out.println("Electric Vehicle Details:");
        ev.displayVehicleInfo();
        ev.charge();

        System.out.println("\nPetrol Vehicle Details:");
        pv.displayVehicleInfo();
        pv.refuel();
    }
}