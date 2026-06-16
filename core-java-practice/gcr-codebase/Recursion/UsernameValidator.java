import java.util.Scanner;

public class UsernameValidator {

    // Recursive function to check if username contains only lowercase letters
    static boolean isValidUsername(String username, int index) {
        // Base case: all characters checked
        if (index == username.length()) {
            return true;
        }

        char ch = username.charAt(index);

        // Check if current character is a lowercase letter
        if (ch < 'a' || ch > 'z') {
            return false;
        }

        // Recursively check the next character
        return isValidUsername(username, index + 1);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter username: ");
            String username = sc.nextLine();

            boolean result = isValidUsername(username, 0);

            System.out.println(result);
        }
    }
}