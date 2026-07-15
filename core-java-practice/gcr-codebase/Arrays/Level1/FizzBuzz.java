package Level1;
import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = sc.nextInt();
        if (n > 0) {
            String[] results = new String[n + 1];
            for (int i = 0; i <= n; i++) {
                if (i % 3 == 0 && i % 5 == 0 && i != 0) {
                    results[i] = "FizzBuzz";
                } else if (i % 3 == 0 && i != 0) {
                    results[i] = "Fizz";
                } else if (i % 5 == 0 && i != 0) {
                    results[i] = "Buzz";
                } else {
                    results[i] = String.valueOf(i);
                }
            }
            for (int i = 0; i <= n; i++) {
                System.out.println("Position " + i + " = " + results[i]);
            }
        } else {
            System.out.println("Invalid input");
        }
    }
}

