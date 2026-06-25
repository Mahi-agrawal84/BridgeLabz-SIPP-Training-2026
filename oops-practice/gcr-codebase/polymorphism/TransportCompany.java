abstract class Vehicle {
    String vehicleNumber;

    Vehicle(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    abstract double fuelCost(double km);
}

class Car extends Vehicle {
    Car(String vehicleNumber) {
        super(vehicleNumber);
    }

    @Override
    double fuelCost(double km) {
        return km * 8;
    }
}

class Bus extends Vehicle {
    Bus(String vehicleNumber) {
        super(vehicleNumber);
    }

    @Override
    double fuelCost(double km) {
        return km * 15;
    }
}

class Bike extends Vehicle {
    Bike(String vehicleNumber) {
        super(vehicleNumber);
    }

    @Override
    double fuelCost(double km) {
        return km * 3;
    }
}

class ElectricCar extends Vehicle {
    ElectricCar(String vehicleNumber) {
        super(vehicleNumber);
    }

    @Override
    double fuelCost(double km) {
        return km * 2;
    }
}

public class TransportCompany {

    public static void main(String[] args) {

        Vehicle[] fleet = {
                new Car("CAR101"),
                new Bus("BUS201"),
                new Bike("BIKE301"),
                new ElectricCar("EC401")
        };

        double km = 100;

        for (Vehicle v : fleet) {

            System.out.println("\nVehicle Number: " + v.vehicleNumber);
            System.out.println("Fuel Cost for " + km + " km = ₹" + v.fuelCost(km));

            if (v instanceof Car) {
                System.out.println("Type: Car");
            } else if (v instanceof Bus) {
                System.out.println("Type: Bus");
            } else if (v instanceof Bike) {
                System.out.println("Type: Bike");
            } else if (v instanceof ElectricCar) {
                System.out.println("Type: Electric Car");
            }
        }
    }
}