package nirmal.strings;

public class ReverseTheString {
    //reverse the String
    public static String reverse(String str){
        StringBuilder reversed = new StringBuilder();
        for(int i = str.length()-1;i>=0;i--){
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }

    public static String reverse2(String str){
        StringBuilder reversed = new StringBuilder(str);
        return reversed.reverse().toString();
    }

    public static void main(String[] args) {
        String str = "abcde";
        System.out.println(reverse(str));
    }
}
