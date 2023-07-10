package nirmal.strings;

public class AllSubsequences {

    //Recursion
    public static void printSubsequences(String str){
        printSubsequenceHelper(str,"",0);
    }

    private static void printSubsequenceHelper(String str,String current,int index){
        if(index == str.length()){
            System.out.println(current);
            return;
        }
        // Include the current character
        printSubsequenceHelper(str,current+str.charAt(index),index+1);

        // Exclude the current character
        printSubsequenceHelper(str,current,index+1);
    }


    //using a binary Counter to generate all possible subsequence

    public static void printSubsequence(String str){
        int n = str.length();
        int totalSubsequence = (int) Math.pow(2,n);

        for(int i = 0; i < totalSubsequence; i++){
            StringBuilder subsequence = new StringBuilder();

            for(int j = 0 ; j < n ;j++){
                if((i&(1<<j))!=0){
                    subsequence.append(str.charAt(j));
                }
            }
            System.out.println(subsequence);
        }
    }

    public static void main(String[] args) {
        printSubsequences("ABC");
        printSubsequence("ABCD");
    }
}
