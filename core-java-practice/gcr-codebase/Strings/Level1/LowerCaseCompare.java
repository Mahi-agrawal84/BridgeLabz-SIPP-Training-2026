package Level1;
import java.util.Scanner;

public class LowerCaseCompare {
    public static String toLowerManual(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32);
            }
            result += ch;
        }
        return result;
    }

    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();
        String manualLower = toLowerManual(input);
        String builtInLower = input.toLowerCase();
        boolean isEqual = compareStrings(manualLower, builtInLower);
        System.out.println("Manual Lowercase: " + manualLower);
        System.out.println("Built-in Lowercase: " + builtInLower);
        System.out.println("Are both equal? " + isEqual);
    }
}


