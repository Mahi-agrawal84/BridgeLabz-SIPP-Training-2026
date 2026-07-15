package DSA.Stack;

import java.util.Stack;

public class BalancedBracketValidator {

    public static boolean isBalanced(String str) {

        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {

                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {

        String str = "{[()]}";

        if (isBalanced(str)) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not Balanced");
        }
    }
}