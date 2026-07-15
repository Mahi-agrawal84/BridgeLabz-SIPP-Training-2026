package DSA.Stack;

import java.util.Stack;
import java.util.Arrays;

public class ServerLoadSpan {

    // Method to calculate the load span
    public static int[] loadSpan(int[] load) {

        int n = load.length;
        int[] span = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && load[stack.peek()] <= load[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - stack.peek();
            }

            stack.push(i);
        }

        return span;
    }

    public static void main(String[] args) {

        int[] load = {30, 35, 40, 38, 35, 45, 50};

        int[] span = loadSpan(load);

        System.out.println("Server Load Readings:");
        System.out.println(Arrays.toString(load));

        System.out.println("Load Span:");
        System.out.println(Arrays.toString(span));
    }
}