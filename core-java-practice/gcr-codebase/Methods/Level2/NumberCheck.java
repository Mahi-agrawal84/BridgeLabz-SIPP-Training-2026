package Level2;
import java.util.Scanner;

public class NumberCheck {
    static boolean isPositive(int n) {
        return n > 0;
    }

    static boolean isEven(int n) {
        return n % 2 == 0;
    }

    static int compare(int a, int b) {
        if (a > b) return 1;
        else if (a == b) return 0;
        else return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < arr.length; i++) {
            if (isPositive(arr[i])) {
                if (isEven(arr[i])) System.out.println(arr[i] + " is Positive Even");
                else System.out.println(arr[i] + " is Positive Odd");
            } else {
                System.out.println(arr[i] + " is Negative");
            }
        }
        int result = compare(arr[0], arr[arr.length - 1]);
        if (result == 0) System.out.println("First and last elements are Equal");
        else if (result == 1) System.out.println("First element is Greater");
        else System.out.println("First element is Less");
    }
}

