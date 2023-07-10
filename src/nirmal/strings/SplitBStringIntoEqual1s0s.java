package nirmal.strings;

import java.util.Stack;

public class SplitBStringIntoEqual1s0s {

    public static int splitBinaryStrings(String str){
        int zeros = 0;
        int ones = 0;
        int count = 0;

        for(int i = 0;i < str.length(); i++){
            if(str.charAt(i)=='0'){
                zeros++;
            } else if (str.charAt(i)=='1') {
                ones++;
            }

            if(zeros == ones){
                count++;
                zeros = 0;
                ones = 0;
            }
        }
        if(zeros != ones ){
            return -1;
        }

        return count;
    }

    public static int splitBinaryStrings2(String str){
        int ans = 0;
        int i = 0;

        Stack<Character> stack = new Stack<>();
        stack.push(str.charAt(i));
        i++;

        while(i < str.length()){
            while (i < str.length() && !stack.isEmpty() && stack.peek() != str.charAt(i)){
                stack.pop();
                i++;
            }
            if(stack.isEmpty()){
                ans++;
            }

            while(i<str.length() && (stack.empty() || stack.peek()==str.charAt(i))){
                stack.push(str.charAt(i));
                i++;
            }

        }
        if(stack.empty())
            return ans;
        return -1;
    }
    public static void main(String[] args) {
        String str = "0100110101";
        int n = str.length();

        System.out.println(splitBinaryStrings2(str));
    }
}
