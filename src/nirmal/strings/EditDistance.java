package nirmal.strings;

public class EditDistance {

    /*find the minimum number of operations
     (insertions, deletions, replacements)
     required to transform one string into another.
      */
    //recursive
    public static int editDistance(String str1,String str2){
        int m = str1.length();
        int n = str2.length();
        return editDistanceR(str1,str2,m,n);
    }

    private static int editDistanceR(String str1, String str2, int m, int n) {
        if (m == 0)
            return n;

        if (n == 0)
            return m;

        if(str1.charAt(m-1) == str2.charAt(n-1)){
            //equal No operation
            return editDistanceR(str1, str2,m-1,n-1);
        }
            int insert = editDistanceR(str1, str2, m, n-1);
            int remove = editDistanceR(str1, str2, m-1, n);
            int substitute = editDistanceR(str1, str2, m-1, n-1);

            return 1 + Math.min(insert,Math.min(remove,substitute));
    }
    public static int editDistance2(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(editDistance("abc" ,"dc"));
    }
}
