import java.util.Scanner;

public class UsernameValidator {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // Accept username
            System.out.print("Enter a username: ");
            String username = sc.nextLine();

            // Check for spaces
            boolean hasSpaces = username.contains(" ");

            // Count characters
            int length = username.length();

            // Convert to uppercase
            String upperCaseUsername = username.toUpperCase();

            // Check palindrome
            String reversed = "";
            for (int i = length - 1; i >= 0; i--) {
                reversed += username.charAt(i);
            }

            boolean isPalindrome = username.equalsIgnoreCase(reversed);

            // Display results
            System.out.println("\n Username Validation Report");
            System.out.println("Username: " + username);
            System.out.println("Contains Spaces: " + (hasSpaces ? "Yes" : "No"));
            System.out.println("Total Characters: " + length);
            System.out.println("Uppercase Username: " + upperCaseUsername);
            System.out.println("Palindrome: " + (isPalindrome ? "Yes" : "No"));
        }
    }
}