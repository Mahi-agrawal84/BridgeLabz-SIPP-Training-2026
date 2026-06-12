package Level1;
import java.util.Scanner;

public class SubstringCompare {
    public static String substringUsingCharAt(String s, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += s.charAt(i);
        }
        return result;
    }

    public static boolean compareUsingCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        int start = sc.nextInt();
        int end = sc.nextInt();
        String sub1 = substringUsingCharAt(text, start, end);
        String sub2 = text.substring(start, end);
        boolean result = compareUsingCharAt(sub1, sub2);
        System.out.println("Substring using charAt: " + sub1);
        System.out.println("Substring using substring(): " + sub2);
        System.out.println("Both substrings are equal: " + result);
    }
}
