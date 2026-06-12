package Level2;
import java.util.*;

public class TrimString {

    static int[] findTrimPoints(String str) {
        int start = 0, end = 0, len = 0;
        try {
            while (true) {
                str.charAt(len);
                len++;
            }
        } catch (Exception e) {}
        while (start < len && str.charAt(start) == ' ') start++;
        end = len - 1;
        while (end >= 0 && str.charAt(end) == ' ') end--;
        return new int[]{start, end};
    }

    static String substringUsingCharAt(String str, int start, int end) {
        String result = "";
        for (int i = start; i <= end; i++) {
            result += str.charAt(i);
        }
        return result;
    }

    static boolean compareStrings(String s1, String s2) {
        int len1 = 0, len2 = 0;
        try {
            while (true) { s1.charAt(len1); len1++; }
        } catch (Exception e) {}
        try {
            while (true) { s2.charAt(len2); len2++; }
        } catch (Exception e) {}
        if (len1 != len2) return false;
        for (int i = 0; i < len1; i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        int[] points = findTrimPoints(text);
        String customTrimmed = substringUsingCharAt(text, points[0], points[1]);
        String builtInTrimmed = text.trim();
        boolean result = compareStrings(customTrimmed, builtInTrimmed);
        System.out.println("Custom Trimmed: [" + customTrimmed + "]");
        System.out.println("Built-in Trimmed: [" + builtInTrimmed + "]");
        System.out.println("Are both equal? " + result);
    }
}

