package Level3;
import java.util.Scanner;

public class CharFrequency {
    public static Object[][] findFrequency(String text) {
        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }
        Object[][] result = new Object[text.length()][2];
        int index = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (freq[c] != 0) {
                result[index][0] = c;
                result[index][1] = freq[c];
                freq[c] = 0;
                index++;
            }
        }
        Object[][] finalResult = new Object[index][2];
        for (int i = 0; i < index; i++) {
            finalResult[i][0] = result[i][0];
            finalResult[i][1] = result[i][1];
        }
        return finalResult;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        Object[][] freq = findFrequency(text);
        for (int i = 0; i < freq.length; i++) {
            System.out.println(freq[i][0] + " -> " + freq[i][1]);
        }
    }
}
