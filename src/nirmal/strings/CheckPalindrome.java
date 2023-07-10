package nirmal.strings;

import static nirmal.strings.ReverseTheString.reverse;

public class CheckPalindrome {

    public static boolean isPalindrome(String str){
        int i = 0;
        int j = str.length() -1;

        while(i < j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    //reversing the string and comparing with the original
    public static boolean isPalindrome2(String str){
        String reversed = reverse(str);
        return str.equals(reversed);
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome("abccba"));

        System.out.println(isPalindrome2("aaabbaaa"));
    }
}
