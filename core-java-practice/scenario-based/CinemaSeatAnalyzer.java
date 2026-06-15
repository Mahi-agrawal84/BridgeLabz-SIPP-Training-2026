import java.util.Scanner;

public class CinemaSeatAnalyzer {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            // Input number of seats
            System.out.print("Enter total number of seats: ");
            int n = sc.nextInt();

            int[] seats = new int[n];

            System.out.println("Enter seat status (0 = Empty, 1 = Booked):");
            for (int i = 0; i < n; i++) {
                seats[i] = sc.nextInt();
            }

            int booked = 0, available = 0;

            int maxLength = 0;
            int maxStart = -1;
            int maxEnd = -1;

            int currentLength = 0;
            int currentStart = 0;

            // Analyze seats
            for (int i = 0; i < n; i++) {

                if (seats[i] == 1) {
                    booked++;

                    if (currentLength > maxLength) {
                        maxLength = currentLength;
                        maxStart = currentStart;
                        maxEnd = i - 1;
                    }

                    currentLength = 0;
                } else {
                    available++;

                    if (currentLength == 0) {
                        currentStart = i;
                    }

                    currentLength++;
                }
            }

            // Check if longest block is at the end
            if (currentLength > maxLength) {
                maxLength = currentLength;
                maxStart = currentStart;
                maxEnd = n - 1;
            }

            // Display results
            System.out.println("\n Cinema Seat Analysis");
            System.out.println("Total Booked Seats    : " + booked);
            System.out.println("Total Available Seats : " + available);

            if (maxLength > 0) {
                System.out.println("Longest Available Block Length : " + maxLength);
                System.out.println("Starting Position : " + (maxStart + 1));
                System.out.println("Ending Position   : " + (maxEnd + 1));
            } else {
                System.out.println("No available seats.");
            }

            // Check if group of 5 can sit together
            if (maxLength >= 5) {
                System.out.println("Suggestion: YES, a group of 5 can sit together.");
            } else {
                System.out.println("Suggestion: NO, a group of 5 cannot sit together.");
            }
        }
    }
}