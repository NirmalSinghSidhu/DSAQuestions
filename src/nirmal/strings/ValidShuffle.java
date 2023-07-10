package nirmal.strings;

public class ValidShuffle {
    /*
    1XY2 is a valid shuffle of XY and 12
    Y1X2 is a valid shuffle of XY and 12
    Y21XX is not a valid shuffle of XY and 12
     */

    //two pointer approach

    public static boolean isValidShuffle(String str1 ,String str2, String shuffle){
        if(str1.length() + str2.length() != shuffle.length()){
            return false;
        }
        int i = 0 , j = 0;
        for(char ch : shuffle.toCharArray()){
            if(i < str1.length() && str1.charAt(i) == ch){
                i++;
            }
            else if(j < str2.length() && str2.charAt(j) == ch){
                j++;
            }else {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidShuffle2(String str1 , String str2 , String shuffle ){
        if (str1.length() + str2.length() != shuffle.length()) {
            return false;
        }
        int i = 0 , j = 0 , k = 0;
        while(k < shuffle.length()){
            if(i < str1.length() && str1.charAt(i) == shuffle.charAt(k)){
                i++;
            } else if (j < str2.length() && str2.charAt(j) == shuffle.charAt(k)) {
                j++;
            }else{
                return false;
            }
            k++;
        }
        return true;
    }
    public static void main(String[] args) {

        System.out.println(isValidShuffle2("XY","12","1XY2"));
        System.out.println(isValidShuffle2("XY","12","1XYX2"));

    }
}
