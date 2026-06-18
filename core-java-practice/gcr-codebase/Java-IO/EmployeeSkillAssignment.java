import java.io.*;
import java.util.Scanner;

// Employee class must implement Serializable
class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    int employeeId;
    String name;
    String department;
    double salary;

    public Employee(int employeeId, String name, String department, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public void display() {
        System.out.println("\nRecovered Employee Information:");
        System.out.println("Employee ID : " + employeeId);
        System.out.println("Name        : " + name);
        System.out.println("Department  : " + department);
        System.out.println("Salary      : " + salary);
    }
}

public class EmployeeSkillAssignment {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            // Accept employee data
            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Department: ");
            String department = sc.nextLine();

            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();

            Employee emp = new Employee(id, name, department, salary);

            // Serialization using try-with-resources
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employee.ser"))) {
                oos.writeObject(emp);
            }

            System.out.println("\nEmployee object serialized successfully.");

            // Deserialization using try-with-resources
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employee.ser"))) {
                Employee recoveredEmp = (Employee) ois.readObject();
                // Display recovered employee information
                recoveredEmp.display();
            } catch (ClassNotFoundException e) {
                System.out.println("Class not found.");
            }

        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }
    }
}