import java.util.*;

public class LongestStableWaterLevel {

    public static int longestStablePeriod(int[] levels, int limit) {
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < levels.length; right++) {

            while (!maxDeque.isEmpty() && levels[maxDeque.peekLast()] < levels[right])
                maxDeque.pollLast();
            maxDeque.offerLast(right);

            while (!minDeque.isEmpty() && levels[minDeque.peekLast()] > levels[right])
                minDeque.pollLast();
            minDeque.offerLast(right);

            while (levels[maxDeque.peek()] - levels[minDeque.peek()] > limit) {
                if (maxDeque.peek() == left)
                    maxDeque.poll();
                if (minDeque.peek() == left)
                    minDeque.poll();
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] levels = {8, 2, 4, 7};
        int limit = 4;

        System.out.println("Longest Stable Period: " + longestStablePeriod(levels, limit));
    }
}