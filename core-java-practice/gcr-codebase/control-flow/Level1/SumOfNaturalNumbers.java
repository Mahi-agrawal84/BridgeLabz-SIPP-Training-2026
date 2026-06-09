package Level1;
import java.util.Scanner;
public class SumOfNaturalNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n >= 0) {
            int sumLoop = 0;
            int i = 1;
            while (i <= n) {
                sumLoop += i;
                i++;
            }
            int sumFormula = n * (n + 1) / 2;
            System.out.println("Sum using while loop: " + sumLoop);
            System.out.println("Sum using formula: " + sumFormula);
            if (sumLoop == sumFormula) {
                System.out.println("Both computations are correct.");
            } else {
                System.out.println("There is a mismatch.");
            }
        } else {
            System.out.println("The number " + n + " is not a natural number");
        }
    }
}

