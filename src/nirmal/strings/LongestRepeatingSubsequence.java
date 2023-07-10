package nirmal.strings;

public class LongestRepeatingSubsequence {

    public  static int longestRepeatingSubsequence(String str){
        int n = str.length();
        int[] dp = new int[n+1];
        int prev;

        for(int i = 1; i<=n; i++){
            prev = dp[0];
            for(int j = 1; j<=n;j++){
                int temp = dp[j];
                if(str.charAt(i-1) == str.charAt(j-1) && i!=j){
                    dp[j]= 1+prev;
                }else{
                    dp[j] = Math.max(dp[j-1],dp[j]);
                }
                prev = temp;
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {

    }
}
