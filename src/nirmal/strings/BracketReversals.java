package nirmal.strings;

import java.util.Stack;

public class BracketReversals {
    public static int countMinimumReversals(String expression) {
        int length = expression.length();
        if (length % 2 != 0) {
            return -1; // Expression can't be balanced
        }

        Stack<Character> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (c == '{') {
                stack.push(c);
            } else if (c == '}') {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        int openBrackets = 0;
        int closedBrackets = 0;
        while (!stack.isEmpty()) {
            if (stack.pop() == '{') {
                openBrackets++;
            } else {
                closedBrackets++;
            }
        }

        return (int) (Math.ceil(openBrackets / 2.0) + Math.ceil(closedBrackets / 2.0));
    }

    public static void main(String[] args) {
        String expression = "{{}}{{}{{";
        int minReversals = countMinimumReversals(expression);
        System.out.println("Minimum reversals needed: " + minReversals);
    }
}
