package nirmal.strings;

import static nirmal.strings.LongestCommonSubsequence.longestCommonSubsequence;

public class LongestPalindrome {

    public static String longestPalindrome(String str){
        if(str == null || str.length() < 2){
            return str;
        }
        int maxLength = 0;
        int start = 0;
        int end = 0;

        for(int i = 0 ; i<str.length();i++){
            int len1= expandFromCenter(str,i,i);   //oddlength
            int len2= expandFromCenter(str,i,i+1);  //even length

            int length = Math.max(len1,len2);
            if(length > maxLength){
                maxLength = length;
                start = i-(length - 1)/2;
                end = i+ length/2;
            }
        }
        return str.substring(start,end+1);
    }

    private static int expandFromCenter(String str , int left ,int right){
        while(left>=0 && right < str.length() && str.charAt(left) == str.charAt(right)){
            left--;
            right++;
        }
        return right - left -1;
    }

    public static int longestPalindrome2(String str){
        String t = str;
        String ss = new StringBuilder(str).reverse().toString();
        return longestCommonSubsequence(ss,t);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abacbbc"));
        String s= "bbabcbcab";

        System.out.print("The Length of Longest Palindromic Subsequence is ");
        System.out.println(longestPalindrome2(s));
    }
}
