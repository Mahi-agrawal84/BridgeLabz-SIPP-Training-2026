import java.util.Scanner;

public class ConsecutiveSensorReadings {

    // Recursive function to check if array is strictly increasing
    static boolean isStrictlyIncreasing(int[] readings, int index) {
        // Base case: reached end of array
        if (index == readings.length - 1) {
            return true;
        }

        // If current element is not less than next, return false
        if (readings[index] >= readings[index + 1]) {
            return false;
        }

        // Recursively check remaining elements
        return isStrictlyIncreasing(readings, index + 1);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter number of readings: ");
            int n = sc.nextInt();

            int[] readings = new int[n];

            System.out.println("Enter the readings:");
            for (int i = 0; i < n; i++) {
                readings[i] = sc.nextInt();
            }

            boolean result = isStrictlyIncreasing(readings, 0);

            System.out.println(result);
        }
    }
}