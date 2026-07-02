import java.util.*;

public class LowerBoundDemo {

    public static void addNumbers(List<? super Integer> list) {
        list.add(100);
        list.add(200);
    }

    public static void main(String[] args) {
        List<Number> list = new ArrayList<>();

        addNumbers(list);

        System.out.println(list);
    }
}