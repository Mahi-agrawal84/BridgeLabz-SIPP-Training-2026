package Level1;
import java.util.Scanner;

public class IllegalArgumentDemo {
    public static void generateException(String text) {
        String result = text.substring(5, 2);
        System.out.println(result);
    }

    public static void handleException(String text) {
        try {
            String result = text.substring(5, 2);
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        generateException(input);
        handleException(input);
    }
}

