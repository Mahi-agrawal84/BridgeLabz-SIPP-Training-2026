import java.util.Scanner;

public class ElectionBooth {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int candidate1Votes = 0;
            int candidate2Votes = 0;
            int candidate3Votes = 0;

            while (true) {
                System.out.print("\nEnter age (or -1 to exit): ");
                int age = sc.nextInt();

                if (age == -1) {
                    break;
                }

                // Check voter eligibility
                if (age >= 18) {
                    System.out.println("Eligible to vote!");

                    System.out.println("Choose a candidate:");
                    System.out.println("1. Candidate A");
                    System.out.println("2. Candidate B");
                    System.out.println("3. Candidate C");

                    System.out.print("Enter your vote (1, 2, or 3): ");
                    int vote = sc.nextInt();

                    switch (vote) {
                        case 1 -> {
                            candidate1Votes++;
                            System.out.println("Vote recorded for Candidate A.");
                        }
                        case 2 -> {
                            candidate2Votes++;
                            System.out.println("Vote recorded for Candidate B.");
                        }
                        case 3 -> {
                            candidate3Votes++;
                            System.out.println("Vote recorded for Candidate C.");
                        }
                        default -> System.out.println("Invalid vote!");
                    }
                } else {
                    System.out.println("Not eligible to vote.");
                }
            }

            // Display final results
            System.out.println("\nElection Results");
            System.out.println("Candidate A Votes: " + candidate1Votes);
            System.out.println("Candidate B Votes: " + candidate2Votes);
            System.out.println("Candidate C Votes: " + candidate3Votes);
        }
    }
}