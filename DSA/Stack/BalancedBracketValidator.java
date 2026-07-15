package DSA.Stack;

import java.util.Stack;

public class BalancedBracketValidator {

    // Method to check whether the brackets are balanced
    public static boolean isValidConfig(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            switch (ch) {
                case '(', '{', '[' -> stack.push(ch);
                case ')' -> {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                }
                case '}' -> {
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                }
                case ']' -> {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                }
                default -> {}
            }
        }

        // Stack must be empty for a valid expression
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        String s1 = "{[()]}";
        String s2 = "{[(])}";
        String s3 = "((()))";
        String s4 = "{[()";

        System.out.println(s1 + " -> " + isValidConfig(s1));
        System.out.println(s2 + " -> " + isValidConfig(s2));
        System.out.println(s3 + " -> " + isValidConfig(s3));
        System.out.println(s4 + " -> " + isValidConfig(s4));
    }
}