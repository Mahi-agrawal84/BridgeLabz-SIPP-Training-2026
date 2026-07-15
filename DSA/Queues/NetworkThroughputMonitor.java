package DSA.Queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NetworkThroughputMonitor {

    // Method to find maximum throughput in every window of size k
    public static int[] maxThroughputWindow(int[] readings, int k) {

        int n = readings.length;

        if (k > n || k <= 0) {
            return new int[0];
        }

        int[] result = new int[n - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // Remove indices that are outside the current window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Remove smaller elements from the back
            while (!deque.isEmpty() && readings[deque.peekLast()] <= readings[i]) {
                deque.pollLast();
            }

            // Add current index
            deque.offerLast(i);

            // Store maximum for current window
            if (i >= k - 1) {
                result[i - k + 1] = readings[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] readings = {10, 5, 8, 12, 15, 7, 18, 20};
        int k = 3;

        int[] result = maxThroughputWindow(readings, k);

        System.out.println("Network Throughput Readings:");
        System.out.println(Arrays.toString(readings));

        System.out.println("\nWindow Size: " + k);

        System.out.println("\nMaximum Throughput in Each Window:");
        System.out.println(Arrays.toString(result));
    }
}