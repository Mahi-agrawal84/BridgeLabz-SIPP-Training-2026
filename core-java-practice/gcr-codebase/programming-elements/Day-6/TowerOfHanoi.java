import java.util.Scanner;

public class TowerOfHanoi {

    static int moveCount = 0;

    // 1. Tower of Hanoi
    static void towerOfHanoi(int n, char source, char auxiliary, char destination) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            moveCount++;
            return;
        }

        towerOfHanoi(n - 1, source, destination, auxiliary);

        System.out.println("Move disk " + n + " from " + source + " to " + destination);
        moveCount++;

        towerOfHanoi(n - 1, auxiliary, source, destination);
    }

    // 2. Recursive Binary Search
    static int binarySearch(int[] arr, int low, int high, int key) {
        if (low > high)
            return -1;

        int mid = low + (high - low) / 2;

        if (arr[mid] == key)
            return mid;

        if (key < arr[mid])
            return binarySearch(arr, low, mid - 1, key);

        return binarySearch(arr, mid + 1, high, key);
    }

    // 3. Recursive Sum of Digits
    static int sumOfDigits(int n) {
        if (n == 0)
            return 0;

        return (n % 10) + sumOfDigits(n / 10);
    }

    // 4. Recursive Reverse String
    static String reverseString(String str) {
        if (str.isEmpty())
            return str;

        return reverseString(str.substring(1)) + str.charAt(0);
    }

    // 5. Balanced Parentheses Without Stack
    static boolean isBalanced(String str) {
        return checkBalance(str, 0, 0);
    }

    static boolean checkBalance(String str, int index, int count) {
        if (count < 0)
            return false;

        if (index == str.length())
            return count == 0;

        char ch = str.charAt(index);

        return switch (ch) {
            case '(' -> checkBalance(str, index + 1, count + 1);
            case ')' -> checkBalance(str, index + 1, count - 1);
            default -> checkBalance(str, index + 1, count);
        };
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            // Tower of Hanoi
            System.out.print("Enter number of disks: ");
            int n = sc.nextInt();

            System.out.println("\nTower of Hanoi Moves:");
            towerOfHanoi(n, 'A', 'B', 'C');
            System.out.println("Total Moves = " + moveCount);

            // Binary Search
            int[] prices = {100, 200, 300, 400, 500, 600, 700};

            System.out.print("\nEnter price to search: ");
            int key = sc.nextInt();

            int result = binarySearch(prices, 0, prices.length - 1, key);

            if (result != -1)
                System.out.println("Price found at index: " + result);
            else
                System.out.println("Price not found.");

            // Sum of Digits
            System.out.print("\nEnter a number: ");
            int num = sc.nextInt();

            System.out.println("Sum of digits = " + sumOfDigits(num));

            sc.nextLine(); // consume newline

            // Reverse String
            System.out.print("\nEnter a string: ");
            String str = sc.nextLine();

            System.out.println("Reversed String = " + reverseString(str));

            // Balanced Parentheses
            System.out.print("\nEnter parentheses string: ");
            String parentheses = sc.nextLine();

            if (isBalanced(parentheses))
                System.out.println("Balanced Parentheses");
            else
                System.out.println("Not Balanced");
        }
    }
}