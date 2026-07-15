import java.util.HashSet;
import java.util.Scanner;

public class EventEntryVerificationSystem {

    // HashSet to store unique participant email IDs
    private final HashSet<String> participants = new HashSet<>();

    // Register Participant
    public void registerParticipant(String email) {
        if (participants.add(email)) {
            System.out.println("Registration Successful.");
        } else {
            System.out.println("Duplicate Registration! Entry Rejected.");
        }
    }

    // Display All Participants
    public void displayParticipants() {
        if (participants.isEmpty()) {
            System.out.println("No participants registered.");
        } else {
            System.out.println("\nRegistered Participants:");
            for (String email : participants) {
                System.out.println(email);
            }
            System.out.println("Total Eligible Attendees: " + participants.size());
        }
    }

    public static void main(String[] args) {
        EventEntryVerificationSystem event = new EventEntryVerificationSystem();

        int choice;

        try (Scanner sc = new Scanner(System.in)) {
            do {
                System.out.println("\n Event Entry Verification System ");
                System.out.println("1. Register Participant");
                System.out.println("2. Display Registered Participants");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");

                choice = sc.nextInt();
                sc.nextLine(); // Consume newline

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter Participant Email ID: ");
                        String email = sc.nextLine();
                        event.registerParticipant(email);
                    }
                    case 2 -> event.displayParticipants();
                    case 3 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid Choice! Please try again.");
                }

            } while (choice != 3);
        }
    }
}