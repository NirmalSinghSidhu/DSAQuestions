package nirmal.strings;

public class Permutations {

    public static void printPermutations(String str){

    }

    private static void printPermutations(char[] chars ,int index){
        if(index == chars.length - 1){
            System.out.println(new String(chars));
            return;
        }

        for(int i = index ; i< chars.length; i++){
            swap(chars,index,i);
            printPermutations(chars,index+1);
            swap(chars,index,i); //backtrack
        }
    }
    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
