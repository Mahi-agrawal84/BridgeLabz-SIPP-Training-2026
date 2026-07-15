import java.util.*;

public class TypeErasureDemo {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("Java");

        System.out.println(list);

        System.out.println("Generic type information is removed at runtime.");
    }
}