package Level2;
import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        long num = sc.nextLong();
        String str = String.valueOf(Math.abs(num));
        int len = str.length();
        int[] digits = new int[len];
        for (int i = 0; i < len; i++) {
            digits[i] = str.charAt(i) - '0';
        }
        int[] frequency = new int[10];
        for (int i = 0; i < len; i++) {
            frequency[digits[i]]++;
        }
        System.out.println("Digit Frequencies:");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println(i + " -> " + frequency[i]);
            }
        }
    }
}

