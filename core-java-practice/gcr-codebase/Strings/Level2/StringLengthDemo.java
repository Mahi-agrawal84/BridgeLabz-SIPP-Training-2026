package Level2;
import java.util.Scanner;

public class StringLengthDemo {
    public static int findLength(String text) {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.next();
        int manualLength = findLength(input);
        int builtInLength = input.length();
        System.out.println("Manual Length: " + manualLength);
        System.out.println("Built-in Length: " + builtInLength);
    }
}

