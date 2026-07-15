class Pair<T, U> {

    T first;
    U second;

    Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    void display() {
        System.out.println(first + " " + second);
    }
}

public class PairDemo {

    public static void main(String[] args) {

        Pair<String, Integer> pair = new Pair<>("Age", 21);

        pair.display();
    }
}