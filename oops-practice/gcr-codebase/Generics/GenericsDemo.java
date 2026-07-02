import java.util.*;

class Pair<T, U> {
    private final T first;
    private final U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public void display() {
        System.out.println("Pair: " + first + " , " + second);
    }
}

class Stack<T> {
    private final ArrayList<T> stack = new ArrayList<>();

    public void push(T item) {
        stack.add(item);
    }

    public T pop() {
        if (stack.isEmpty()) {
            return null;
        }
        return stack.remove(stack.size() - 1);
    }

    public void display() {
        System.out.println("Stack: " + stack);
    }
}

class Repository<T> {
    private final ArrayList<T> data = new ArrayList<>();

    public void add(T item) {
        data.add(item);
    }

    public void display() {
        System.out.println("Repository: " + data);
    }
}

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public String toString() {
        return id + " " + name;
    }
}

public class GenericsDemo {

    public static <T extends Comparable<T>> T findMax(T[] arr) {
        T max = arr[0];

        for (T item : arr) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }

        return max;
    }

    public static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {

        Pair<String, Integer> pair = new Pair<>("Age", 21);
        pair.display();

        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.display();

        System.out.println("Popped: " + stack.pop());

        stack.display();

        Integer[] numbers = {12, 45, 67, 23, 89, 34};
        System.out.println("Maximum: " + findMax(numbers));

        Repository<Student> repository = new Repository<>();
        repository.add(new Student(101, "Mahi"));
        repository.add(new Student(102, "Riya"));

        repository.display();

        List<String> languages = Arrays.asList("Java", "Python", "C++");

        System.out.println("List Elements:");
        printList(languages);
    }
}