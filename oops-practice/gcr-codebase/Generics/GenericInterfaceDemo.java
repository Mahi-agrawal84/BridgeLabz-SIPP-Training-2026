interface Printer<T> {
    void print(T value);
}

class ConsolePrinter<T> implements Printer<T> {

    @Override
    public void print(T value) {
        System.out.println(value);
    }
}

public class GenericInterfaceDemo {

    public static void main(String[] args) {

        Printer<String> printer = new ConsolePrinter<>();

        printer.print("Hello Java");
    }
}