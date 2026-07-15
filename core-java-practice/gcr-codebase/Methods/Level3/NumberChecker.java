package Level3;
import java.util.*;

public class NumberChecker {
    public static int countDigits(int n) {
        return String.valueOf(n).length();
    }

    public static int[] getDigits(int n) {
        String s = String.valueOf(n);
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            digits[i] = s.charAt(i) - '0';
        }
        return digits;
    }

    public static boolean isDuck(int[] digits) {
        for (int i = 1; i < digits.length; i++) {
            if (digits[i] == 0) return true;
        }
        return false;
    }

    public static boolean isArmstrong(int[] digits) {
        int n = digits.length;
        int sum = 0;
        for (int d : digits) {
            sum += Math.pow(d, n);
        }
        int num = 0;
        for (int d : digits) {
            num = num * 10 + d;
        }
        return sum == num;
    }

    public static int[] largestAndSecondLargest(int[] digits) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        for (int d : digits) {
            if (d > max1) {
                max2 = max1;
                max1 = d;
            } else if (d > max2 && d != max1) {
                max2 = d;
            }
        }
        return new int[]{max1, max2};
    }

    public static int[] smallestAndSecondSmallest(int[] digits) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int d : digits) {
            if (d < min1) {
                min2 = min1;
                min1 = d;
            } else if (d < min2 && d != min1) {
                min2 = d;
            }
        }
        return new int[]{min1, min2};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] digits = getDigits(num);
        System.out.println("Count of digits: " + countDigits(num));
        System.out.println("Digits: " + Arrays.toString(digits));
        System.out.println("Duck Number: " + isDuck(digits));
        System.out.println("Armstrong Number: " + isArmstrong(digits));
        int[] largest = largestAndSecondLargest(digits);
        int[] smallest = smallestAndSecondSmallest(digits);
        System.out.println("Largest: " + largest[0] + ", Second Largest: " + largest[1]);
        System.out.println("Smallest: " + smallest[0] + ", Second Smallest: " + smallest[1]);
    }
}
