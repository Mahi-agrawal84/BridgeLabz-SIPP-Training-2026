package Level2;
import java.util.*;

public class SplitWordsComparison {
    
    static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {}
        return count;
    }

    static String[] splitWords(String str) {
        int len = getLength(str);
        int spaceCount = 0;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                spaceCount++;
            }
        }
        int[] spaces = new int[spaceCount + 2];
        int index = 1;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                spaces[index++] = i;
            }
        }
        spaces[0] = -1;
        spaces[spaceCount + 1] = len;
        String[] words = new String[spaceCount + 1];
        for (int i = 0; i < words.length; i++) {
            String w = "";
            for (int j = spaces[i] + 1; j < spaces[i + 1]; j++) {
                w += str.charAt(j);
            }
            words[i] = w;
        }
        return words;
    }

    static boolean compareArrays(String[] a, String[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] customSplit = splitWords(text);
        String[] builtInSplit = text.split(" ");
        boolean result = compareArrays(customSplit, builtInSplit);
        System.out.println("Custom Split: " + Arrays.toString(customSplit));
        System.out.println("Built-in Split: " + Arrays.toString(builtInSplit));
        System.out.println("Are both equal? " + result);
    }
}

