package Level2;
import java.util.*;

public class VowelConsonantType {

    static String checkChar(char ch) {
        if (ch >= 'A' && ch <= 'Z') ch = (char)(ch + 32);
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return "Vowel";
            else return "Consonant";
        }
        return "Not a Letter";
    }

    static String[][] findCharTypes(String str) {
        int len = 0;
        try {
            while (true) {
                str.charAt(len);
                len++;
            }
        } catch (Exception e) {}
        String[][] result = new String[len][2];
        for (int i = 0; i < len; i++) {
            result[i][0] = String.valueOf(str.charAt(i));
            result[i][1] = checkChar(str.charAt(i));
        }
        return result;
    }

    static void display2DArray(String[][] arr) {
        System.out.println("Character\tType");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0] + "\t\t" + arr[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[][] result = findCharTypes(text);
        display2DArray(result);
    }
}
