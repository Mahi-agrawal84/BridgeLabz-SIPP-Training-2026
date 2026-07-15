package Level3;
import java.util.Scanner;

public class UniqueCharacters {
    public static int getLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (Exception e) {
        }
        return count;
    }

    public static char[] findUnique(String text) {
        int len = getLength(text);
        char[] temp = new char[len];
        int uniqueCount = 0;
        for (int i = 0; i < len; i++) {
            char c = text.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == c) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                temp[uniqueCount++] = c;
            }
        }
        char[] result = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = temp[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        char[] unique = findUnique(text);
        for (char c : unique) {
            System.out.print(c + " ");
        }
    }
}

