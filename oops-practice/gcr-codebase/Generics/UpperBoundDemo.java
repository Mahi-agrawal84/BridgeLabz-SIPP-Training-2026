import java.util.*;

public class UpperBoundDemo {

    public static void printNumbers(List<? extends Number> list) {
        for (Number n : list) {
            System.out.println(n);
        }
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30);
        printNumbers(numbers);
    }
}