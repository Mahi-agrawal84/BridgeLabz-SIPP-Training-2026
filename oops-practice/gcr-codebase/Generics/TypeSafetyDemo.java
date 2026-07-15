import java.util.*;

public class TypeSafetyDemo {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        names.add("Mahi");
        names.add("Riya");

        for (String name : names) {
            System.out.println(name);
        }
    }
}