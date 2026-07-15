class Box<T extends Number> {

    T value;

    Box(T value) {
        this.value = value;
    }

    void display() {
        System.out.println(value);
    }
}

public class BoundedTypeDemo {

    public static void main(String[] args) {
        Box<Integer> box = new Box<>(50);
        box.display();
    }
}