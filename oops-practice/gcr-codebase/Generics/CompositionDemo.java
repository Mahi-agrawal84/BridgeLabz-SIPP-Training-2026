class Engine {

    void start() {
        System.out.println("Engine Started");
    }
}

class Car {

    Engine engine = new Engine();

    void drive() {
        engine.start();
        System.out.println("Car is Running");
    }
}

public class CompositionDemo {

    public static void main(String[] args) {

        Car car = new Car();

        car.drive();
    }
}