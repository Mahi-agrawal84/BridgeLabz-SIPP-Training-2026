package DSA.Stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterPrice {

    public static int[] nextGreaterPrice(int[] prices) {

        int n = prices.length;
        int[] result = new int[n];

        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && prices[i] > prices[stack.peek()]) {
                result[stack.pop()] = prices[i];
            }

            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] prices = {100, 80, 120, 90, 150, 110};

        System.out.println(Arrays.toString(nextGreaterPrice(prices)));
    }
}