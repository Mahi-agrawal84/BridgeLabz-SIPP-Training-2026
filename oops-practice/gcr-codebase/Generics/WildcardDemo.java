import java.util.*;

public class WildcardDemo {

    public static void display(List<?> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {

        List<String> names = Arrays.asList("A", "B", "C");

        display(names);
    }
}