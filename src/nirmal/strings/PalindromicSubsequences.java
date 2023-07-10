
package nirmal.strings;

public class PalindromicSubsequences {
    public static int countPalindromicSubsequences(String str) {
        int length = str.length();
        int[][] dp = new int[length][length];

        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }

        for (int len = 2; len <= length; len++) {
            for (int i = 0; i < length - len + 1; i++) {
                int j = i + len - 1;

                if (str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                }
            }
        }

        return dp[0][length - 1];
    }

    public static void main(String[] args) {
        String str = "abcd";
        int count = countPalindromicSubsequences(str);
        System.out.println("Count of palindromic subsequences: " + count);
    }
}
