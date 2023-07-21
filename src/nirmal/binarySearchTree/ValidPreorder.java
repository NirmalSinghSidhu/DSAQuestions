package nirmal.binarySearchTree;

import java.util.Stack;

public class ValidPreorder {
        public static boolean isValidPreorder(int[] preorder) {
            Stack<Integer> stack = new Stack<>();
            int min = Integer.MIN_VALUE;

            for (int value : preorder) {
                if (value < min) {
                    return false;
                }

                while (!stack.isEmpty() && value > stack.peek()) {
                    min = stack.pop();
                }

                stack.push(value);
            }

            return true;
        }
        public static void main(String[] args) {
            int[] preorder1 = {5, 3, 2, 4, 7};
            int[] preorder2 = {5, 3, 6, 2, 4};


            boolean valid1 = isValidPreorder(preorder1);
            boolean valid2 = isValidPreorder(preorder2);

            System.out.println("Is Preorder Sequence 1 Valid? " + valid1);
            System.out.println("Is Preorder Sequence 2 Valid? " + valid2);
        }
    }

