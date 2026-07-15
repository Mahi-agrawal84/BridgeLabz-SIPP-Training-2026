import java.util.ArrayList;
import java.util.List;

abstract class Category {
    String categoryName;

    Category(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return categoryName;
    }
}

class BookCategory extends Category {
    BookCategory() {
        super("Books");
    }
}

class ClothingCategory extends Category {
    ClothingCategory() {
        super("Clothing");
    }
}

class GadgetCategory extends Category {
    GadgetCategory() {
        super("Gadgets");
    }
}

class Product<T extends Category> {

    private final String productName;
    private double price;
    private final T category;

    Product(String productName, double price, T category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void display() {
        System.out.println("Product : " + productName);
        System.out.println("Category : " + category);
        System.out.println("Price : ₹" + price);
        System.out.println();
    }
}

public class OnlineMarketplace {

    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discount = product.getPrice() * percentage / 100;
        product.setPrice(product.getPrice() - discount);
    }

    public static void main(String[] args) {

        Product<BookCategory> book =
                new Product<>("Java Programming", 800, new BookCategory());

        Product<ClothingCategory> shirt =
                new Product<>("T-Shirt", 1200, new ClothingCategory());

        Product<GadgetCategory> laptop =
                new Product<>("Laptop", 60000, new GadgetCategory());

        List<Product<?>> catalog = new ArrayList<>();

        catalog.add(book);
        catalog.add(shirt);
        catalog.add(laptop);

        System.out.println("Products Before Discount");
        System.out.println("");

        for (Product<?> p : catalog) {
            p.display();
        }

        applyDiscount(book, 10);
        applyDiscount(shirt, 20);
        applyDiscount(laptop, 15);

        System.out.println("Products After Discount");
        System.out.println("");

        for (Product<?> p : catalog) {
            p.display();
        }
    }
}