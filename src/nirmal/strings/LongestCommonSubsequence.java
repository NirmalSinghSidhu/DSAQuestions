package nirmal.strings;

import java.util.Arrays;

public class LongestCommonSubsequence {

    //difficult
    public static int longestCommonSubsequence(String str1,String str2){
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n][m];
        for(int rows[] : dp){
            Arrays.fill(rows,-1);
        }
        return lcsDP(str1,str2,n-1,m-1,dp);
    }

    private static int lcsDP(String str1, String str2, int id1, int id2, int[][] dp) {
        if(id1<0 || id2<0){
            return 0;
        }
        if(dp[id1][id2] !=-1)
            return dp[id1][id2];

        if(str1.charAt(id1)==str2.charAt(id2)){
            return dp[id1][id2] = 1 + lcsDP(str1, str2, id1-1, id2-1, dp);
        }
        else{
            return dp[id1][id2]= Math.max(lcsDP(str1, str2, id1 - 1, id2, dp), lcsDP(str1, str2, id1, id2 - 1, dp));
        }
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcsdfg","csdf"));
    }
}
