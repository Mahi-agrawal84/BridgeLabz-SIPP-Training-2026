package Level1;
import java.util.Scanner;

public class StringCharComparison {
    static char[] getChars(String str) {
        char[] arr = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }
        return arr;
    }

    static boolean compareArrays(char[] a, char[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        char[] userMethod = getChars(text);
        char[] builtIn = text.toCharArray();
        boolean result = compareArrays(userMethod, builtIn);
        System.out.println("User Method: ");
        for (char c : userMethod) System.out.print(c + " ");
        System.out.println("\nBuilt-in Method: ");
        for (char c : builtIn) System.out.print(c + " ");
        System.out.println("\nAre both equal? " + result);
    }
}

