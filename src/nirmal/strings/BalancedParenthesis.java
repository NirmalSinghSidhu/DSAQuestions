package nirmal.strings;

import java.util.Stack;

public class BalancedParenthesis {
    public static boolean isBalancedParenthesis(String str){
        Stack<Character> stack = new Stack<>();

        for(char ch : str.toCharArray()){
            if(ch=='(' || ch == '[' || ch == '{'){
                stack.push(ch);
            } else if (ch==')' || ch =='}' || ch == ']') {
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();

                if(((ch == ')' && top != '(')) || (ch ==']' && top != '[') || (ch=='}' && top !='{')){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
