package Level2;
import java.util.*;

public class WordsWithLengths {

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
            if (str.charAt(i) == ' ') spaceCount++;
        }
        int[] spaces = new int[spaceCount + 2];
        int index = 1;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') spaces[index++] = i;
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

    static String[][] wordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getLength(words[i]));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] words = splitWords(text);
        String[][] wordLengths = wordsWithLengths(words);
        System.out.println("Word\tLength");
        for (int i = 0; i < wordLengths.length; i++) {
            System.out.println(wordLengths[i][0] + "\t" + Integer.parseInt(wordLengths[i][1]));
        }
    }
}

