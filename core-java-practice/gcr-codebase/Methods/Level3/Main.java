package Level3;
import java.util.*;

class NumberCheckerr{
    public static int countDigits(int n) {
        return String.valueOf(n).length();
    }

    public static int[] getDigits(int n) {
        String s = String.valueOf(n);
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) digits[i] = s.charAt(i) - '0';
        return digits;
    }

    public static int[] reverseArray(int[] arr) {
        int[] rev = new int[arr.length];
        for (int i = 0; i < arr.length; i++) rev[i] = arr[arr.length - 1 - i];
        return rev;
    }

    public static boolean compareArrays(int[] a, int[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) if (a[i] != b[i]) return false;
        return true;
    }

    public static boolean isPalindrome(int n) {
        int[] digits = getDigits(n);
        int[] rev = reverseArray(digits);
        return compareArrays(digits, rev);
    }

    public static boolean isDuckNumber(int n) {
        int[] digits = getDigits(n);
        for (int i = 1; i < digits.length; i++) if (digits[i] == 0) return true;
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println("Count of digits: " + NumberCheckerr.countDigits(num));
        System.out.println("Palindrome: " + NumberCheckerr.isPalindrome(num));
        System.out.println("Duck Number: " + NumberCheckerr.isDuckNumber(num));
    }
}
