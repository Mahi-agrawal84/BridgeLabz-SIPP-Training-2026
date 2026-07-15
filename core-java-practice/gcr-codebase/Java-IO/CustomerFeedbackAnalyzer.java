import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CustomerFeedbackAnalyzer {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        int count = 0;

        try {
            System.out.println("Enter 5 feedback messages:");

            for (int i = 1; i <= 5; i++) {
                String feedback = br.readLine();

                // Check if feedback contains the word "good"
                if (feedback.toLowerCase().contains("good")) {
                    count++;
                }
            }

            System.out.println("Good Feedback Count = " + count);

        } catch (IOException e) {
            System.out.println("Error reading input: " + e.getMessage());
        }
    }
}