import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem {

    protected String name;

    WarehouseItem(String name) {
        this.name = name;
    }

    abstract void display();
}

class Electronics extends WarehouseItem {

    Electronics(String name) {
        super(name);
    }

    @Override
    void display() {
        System.out.println("Electronics : " + name);
    }
}

class Groceries extends WarehouseItem {

    Groceries(String name) {
        super(name);
    }

    @Override
    void display() {
        System.out.println("Groceries : " + name);
    }
}

class Furniture extends WarehouseItem {

    Furniture(String name) {
        super(name);
    }

    @Override
    void display() {
        System.out.println("Furniture : " + name);
    }
}

class Storage<T extends WarehouseItem> {

    private final List<T> items = new ArrayList<>();

    void addItem(T item) {
        items.add(item);
    }

    List<T> getItems() {
        return items;
    }
}

public class SmartWarehouse {

    static void displayItems(List<? extends WarehouseItem> items) {

        for (WarehouseItem item : items) {
            item.display();
        }
    }

    public static void main(String[] args) {

        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Mobile"));

        Storage<Groceries> groceryStorage = new Storage<>();
        groceryStorage.addItem(new Groceries("Rice"));
        groceryStorage.addItem(new Groceries("Sugar"));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair"));
        furnitureStorage.addItem(new Furniture("Table"));

        System.out.println(" Electronics ");
        displayItems(electronicsStorage.getItems());

        System.out.println();

        System.out.println(" Groceries ");
        displayItems(groceryStorage.getItems());

        System.out.println();

        System.out.println(" Furniture ");
        displayItems(furnitureStorage.getItems());
    }
}