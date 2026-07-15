import java.util.*;

public class SpyAgency {

    // Reverse String
    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    // Check Palindrome
    public static boolean isPalindrome(String str) {
        String reversed = reverseString(str);
        return str.equalsIgnoreCase(reversed);
    }

    // Count Vowels and Consonants
    public static void countVowelsConsonants(String str) {
        int vowels = 0, consonants = 0;

        str = str.toLowerCase();

        for (char ch : str.toCharArray()) {
            if (Character.isLetter(ch)) {
                if ("aeiou".indexOf(ch) != -1)
                    vowels++;
                else
                    consonants++;
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }

    // Check Anagram
    public static boolean isAnagram(String s1, String s2) {
        s1 = s1.replaceAll("\\s", "").toLowerCase();
        s2 = s2.replaceAll("\\s", "").toLowerCase();

        if (s1.length() != s2.length())
            return false;

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    // First Non-Repeating Character
    public static Character firstNonRepeatingChar(String str) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1)
                return entry.getKey();
        }

        return null;
    }

    public static void main(String[] args) {
        // Use try-with-resources for Scanner
        try (Scanner sc = new Scanner(System.in)) {

            // Secret Message
            System.out.print("Enter secret message: ");
            String message = sc.nextLine();

        // Reverse
        String reversed = reverseString(message);
        System.out.println("Reversed Message: " + reversed);

        // Palindrome Check
        if (isPalindrome(message))
            System.out.println("The message is a Palindrome.");
        else
            System.out.println("The message is NOT a Palindrome.");

        // Vowel and Consonant Count
        countVowelsConsonants(message);

        // Anagram Check
        System.out.print("\nEnter first intercept: ");
        String intercept1 = sc.nextLine();

        System.out.print("Enter second intercept: ");
        String intercept2 = sc.nextLine();

        if (isAnagram(intercept1, intercept2))
            System.out.println("The intercepts are Anagrams.");
        else
            System.out.println("The intercepts are NOT Anagrams.");

        // First Non-Repeating Character
        System.out.print("\nEnter surveillance log: ");
        String log = sc.nextLine();

        Character result = firstNonRepeatingChar(log);

        if (result != null)
            System.out.println("First Non-Repeating Character: " + result);
        else
            System.out.println("No non-repeating character found.");

        }
    }
}