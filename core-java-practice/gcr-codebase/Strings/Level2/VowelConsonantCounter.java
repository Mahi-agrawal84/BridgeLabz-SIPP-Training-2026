package Level2;
import java.util.*;

public class VowelConsonantCounter {

    static String checkChar(char ch) {
        if (ch >= 'A' && ch <= 'Z') ch = (char)(ch + 32);
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }
        return "Not a Letter";
    }

    static int[] countVowelsConsonants(String str) {
        int vowels = 0, consonants = 0;
        int i = 0;
        try {
            while (true) {
                char ch = str.charAt(i);
                String result = checkChar(ch);
                if (result.equals("Vowel")) vowels++;
                else if (result.equals("Consonant")) consonants++;
                i++;
            }
        } catch (Exception e) {}
        return new int[]{vowels, consonants};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        int[] result = countVowelsConsonants(text);
        System.out.println("Vowels: " + result[0]);
        System.out.println("Consonants: " + result[1]);
    }
}

