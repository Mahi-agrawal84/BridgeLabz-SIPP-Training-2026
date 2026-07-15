public class PasswordValidator {

    public static void checkPassword(String password) {
        try {
            // Defensive check for null or empty string
            if (password == null) {
                System.out.println("Invalid: Password cannot be null.");
                return;
            }
            if (password.isEmpty()) {
                System.out.println("Invalid: Password cannot be empty.");
                return;
            }

            // Rule 3: Length must be at least 8
            if (password.length() < 8) {
                System.out.println("Invalid: Password must be at least 8 characters long.");
                return;
            }

            // Rule 1: First character must be uppercase
            if (!Character.isUpperCase(password.charAt(0))) {
                System.out.println("Invalid: First character must be uppercase.");
                return;
            }

            // Rule 2: Last character must be a digit
            if (!Character.isDigit(password.charAt(password.length() - 1))) {
                System.out.println("Invalid: Last character must be a digit.");
                return;
            }

            // Rule 4: Must contain at least one special character (@, #, $, %, &, *)
            String specialChars = "@#$%&*";
            boolean hasSpecial = false;
            for (char c : password.toCharArray()) {
                if (specialChars.indexOf(c) != -1) {
                    hasSpecial = true;
                    break;
                }
            }

            if (!hasSpecial) {
                System.out.println("Invalid: Must contain at least one special character (@, #, $, %, &, *).");
                return;
            }

            System.out.println("Success: Password is strong and valid!");

        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Test cases
        checkPassword(null);             // Handles null
        checkPassword("");               // Handles empty
        checkPassword("short1@");        // Handles length
        checkPassword("lower1@pass");    // Handles uppercase
        checkPassword("Upperpass");      // Handles digit
        checkPassword("Upperpass@");     // Handles missing digit
        checkPassword("Strong1@pass");   // Valid case
    }
}