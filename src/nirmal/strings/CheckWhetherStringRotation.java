package nirmal.strings;

public class CheckWhetherStringRotation {
    public static boolean isRotation(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        String concatenated = str1 + str1;
        return concatenated.contains(str2);
    }
    public static boolean isRotation2(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        String concatenated = str1 + str1;
        return concatenated.indexOf(str2) != -1;
    }

    public static void main(String[] args) {
        System.out.println(isRotation("adkfjdkf","sfefds"));
    }
}
