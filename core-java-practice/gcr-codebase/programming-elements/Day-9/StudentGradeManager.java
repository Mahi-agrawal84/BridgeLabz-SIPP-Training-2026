import java.io.*;
import java.util.Scanner;

class Student {
    String name;
    int[] marks = new int[5];
    int total;
    double average;
    String grade;

    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
        calculateResult();
    }

    // Method to calculate total, average and grade
    private void calculateResult() {
        total = 0;

        for (int mark : marks) {
            total += mark;
        }

        average = total / 5.0;

        // Nested Conditions for Grade
        if (average >= 90) {
            grade = "A+";
        } else {
            if (average >= 80) {
                grade = "A";
            } else {
                if (average >= 70) {
                    grade = "B";
                } else {
                    if (average >= 60) {
                        grade = "C";
                    } else {
                        if (average >= 50) {
                            grade = "D";
                        } else {
                            grade = "F";
                        }
                    }
                }
            }
        }
    }
}

public class StudentGradeManager {

    static Student[] students;
    static int count = 0;

    // Read data from file
    public static void readFile(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            int size = Integer.parseInt(br.readLine());
            students = new Student[size];

            String line;

            while ((line = br.readLine()) != null) {
                try {
                    String[] data = line.split(",");

                    String name = data[0];
                    int[] marks = new int[5];

                    for (int i = 0; i < 5; i++) {
                        marks[i] = Integer.parseInt(data[i + 1]);
                    }

                    students[count++] = new Student(name, marks);

                } catch (NumberFormatException e) {
                    System.out.println("Invalid marks format in file.");
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Incomplete student record.");
                }
            }
        }
    }

    // Search student by name
    public static void searchStudent(String name) {
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (students[i].name.equalsIgnoreCase(name)) {
                System.out.println("\nStudent Found:");
                System.out.println("Name: " + students[i].name);
                System.out.println("Total: " + students[i].total);
                System.out.println("Average: " + students[i].average);
                System.out.println("Grade: " + students[i].grade);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    // Bubble Sort by total marks (Descending)
    public static void bubbleSort() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {

                if (students[j].total < students[j + 1].total) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }

    // Write report to output file
    public static void writeReport(String fileName) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write(" STUDENT REPORT \n\n");

            for (int i = 0; i < count; i++) {
                bw.write("Name : " + students[i].name + "\n");
                bw.write("Total : " + students[i].total + "\n");
                bw.write("Average : " + students[i].average + "\n");
                bw.write("Grade : " + students[i].grade + "\n");
                bw.write("\n");
            }
        }
    }

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            // Read student data
            readFile("students.txt");

            // Sort students
            bubbleSort();

            // Search Student
            System.out.print("Enter student name to search: ");
            String name = sc.nextLine();

            searchStudent(name);

            // Write report
            writeReport("report.txt");

            System.out.println("\nReport generated successfully in report.txt");

        } catch (FileNotFoundException e) {
            System.out.println("Student file not found.");
        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }
    }
}