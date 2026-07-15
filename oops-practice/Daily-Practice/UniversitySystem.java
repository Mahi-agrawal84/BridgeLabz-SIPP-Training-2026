class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [Name=" + name + ", Age=" + age + "]";
    }
}

class Student extends Person {
    private final String studentId; // final as required
    private final double gpa;

    public Student(String name, int age, String studentId, double gpa) {
        super(name, age);
        this.studentId = studentId;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return super.toString() +
               ", Student [Student ID=" + studentId +
               ", GPA=" + gpa + "]";
    }
}

class GradStudent extends Student {
    private final String thesis;

    public GradStudent(String name, int age, String studentId,
                       double gpa, String thesis) {
        super(name, age, studentId, gpa);
        this.thesis = thesis;
    }

    @Override
    public String toString() {
        return super.toString() +
               ", GradStudent [Thesis=" + thesis + "]";
    }
}

public class UniversitySystem {
    public static void main(String[] args) {

        GradStudent gradStudent = new GradStudent(
                "Mahi Agrawal",
                23,
                "GS101",
                9.2,
                "Artificial Intelligence in Education"
        );

        System.out.println("Grad Student Details:");
        System.out.println(gradStudent);

        // Demonstrating IS-A relationship
        Student student = gradStudent; // GradStudent IS-A Student
        Person person = gradStudent;   // GradStudent IS-A Person

        System.out.println("\nIS-A Relationship Demonstration:");
        System.out.println("Student Reference: " + student);
        System.out.println("Person Reference: " + person);

        System.out.println("\ninstanceof Check:");
        System.out.println("gradStudent instanceof GradStudent : "
                + (gradStudent instanceof GradStudent));
        System.out.println("gradStudent instanceof Student : "
                + (gradStudent instanceof Student));
        System.out.println("gradStudent instanceof Person : "
                + (gradStudent instanceof Person));
    }
}