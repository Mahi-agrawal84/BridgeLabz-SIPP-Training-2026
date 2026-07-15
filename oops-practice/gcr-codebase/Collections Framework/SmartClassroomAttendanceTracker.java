import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SmartClassroomAttendanceTracker {

    // HashMap: Subject -> List of Students
    private final HashMap<String, ArrayList<String>> attendance = new HashMap<>();

    // Mark Attendance
    public void markAttendance(String subject, String student) {

        // Create subject if it doesn't exist
        attendance.putIfAbsent(subject, new ArrayList<>());

        ArrayList<String> students = attendance.get(subject);

        // Prevent duplicate attendance
        if (students.contains(student)) {
            System.out.println("Attendance already marked for " + student + " in " + subject + ".");
        } else {
            students.add(student);
            System.out.println("Attendance marked successfully.");
        }
    }

    // Display Attendance
    public void displayAttendance() {

        if (attendance.isEmpty()) {
            System.out.println("No attendance records found.");
            return;
        }

        System.out.println("\n Attendance Records ");

        for (String subject : attendance.keySet()) {
            ArrayList<String> students = attendance.get(subject);

            System.out.println("\nSubject: " + subject);
            System.out.println("Students Present:");

            for (String student : students) {
                System.out.println("- " + student);
            }

            System.out.println("Total Students Present: " + students.size());
        }
    }

    public static void main(String[] args) {

        SmartClassroomAttendanceTracker tracker = new SmartClassroomAttendanceTracker();

        try (Scanner sc = new Scanner(System.in)) {
            int choice;

            do {
                System.out.println("\n Smart Classroom Attendance Tracker ");
                System.out.println("1. Mark Attendance");
                System.out.println("2. Display Attendance");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");

                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter Subject Name: ");
                        String subject = sc.nextLine();

                        System.out.print("Enter Student Name: ");
                        String student = sc.nextLine();

                        tracker.markAttendance(subject, student);
                    }
                    case 2 -> tracker.displayAttendance();
                    case 3 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid Choice!");
                }

            } while (choice != 3);
        }
    }
}