import java.util.Arrays;
import java.util.Scanner;

public class WordMatchSystem {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            // Accept two strings
            System.out.print("Enter first skill keyword: ");
            String str1 = sc.nextLine();

            System.out.print("Enter second skill keyword: ");
            String str2 = sc.nextLine();

            // Convert to uppercase
            String upperStr1 = str1.toUpperCase();
            String upperStr2 = str2.toUpperCase();

            // Find lengths
            int len1 = str1.length();
            int len2 = str2.length();

            // Check anagram
            boolean isAnagram = false;

            String s1 = str1.replaceAll("\\s", "").toLowerCase();
            String s2 = str2.replaceAll("\\s", "").toLowerCase();

            if (s1.length() == s2.length()) {
                char[] arr1 = s1.toCharArray();
                char[] arr2 = s2.toCharArray();

                Arrays.sort(arr1);
                Arrays.sort(arr2);

                isAnagram = Arrays.equals(arr1, arr2);
            }

            // Display results
            System.out.println("\n WORD MATCH REPORT");
            System.out.println("First String  : " + upperStr1);
            System.out.println("Second String : " + upperStr2);
            System.out.println("Length of First String  : " + len1);
            System.out.println("Length of Second String : " + len2);

            if (isAnagram) {
                System.out.println("Result: The two keywords are ANAGRAMS.");
                System.out.println("Message: Great! The skills have matching character patterns.");
            } else {
                System.out.println("Result: The two keywords are NOT ANAGRAMS.");
                System.out.println("Message: The skills have different character patterns.");
            }
        }
    }
}