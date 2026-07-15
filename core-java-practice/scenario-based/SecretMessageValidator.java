import java.util.Scanner;

public class SecretMessageValidator {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            // Accept secret code
            System.out.print("Enter Secret Code: ");
            String code = sc.nextLine();

            int vowels = 0;
            int consonants = 0;
            int digits = 0;
            int specialChars = 0;

            // Count vowels, consonants, digits, and special characters
            for (int i = 0; i < code.length(); i++) {
                char ch = code.charAt(i);

                if (Character.isLetter(ch)) {
                    ch = Character.toLowerCase(ch);

                    if (ch == 'a' || ch == 'e' || ch == 'i' ||
                        ch == 'o' || ch == 'u') {
                        vowels++;
                    } else {
                        consonants++;
                    }
                } 
                else if (Character.isDigit(ch)) {
                    digits++;
                } 
                else {
                    specialChars++;
                }
            }

            // Check strength conditions
            boolean isStrong = code.length() >= 8 &&
                               digits >= 2 &&
                               specialChars >= 1;

            // Display report
            System.out.println("\n SECRET CODE REPORT ");
            System.out.println("Code Length        : " + code.length());
            System.out.println("Vowels             : " + vowels);
            System.out.println("Consonants         : " + consonants);
            System.out.println("Digits             : " + digits);
            System.out.println("Special Characters : " + specialChars);
            System.out.println("Strength           : " +
                    (isStrong ? "Strong" : "Weak"));
            System.out.println(" ");
        }
    }
}