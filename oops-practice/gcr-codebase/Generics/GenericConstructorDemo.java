class Student {

    <T> Student(T value) {
        System.out.println(value);
    }
}

public class GenericConstructorDemo {

    public static void main(String[] args) {

        Student s1 = new Student("Mahi");
        System.out.println(s1);

        Student s2 = new Student(101);
        System.out.println(s2);
    }
}