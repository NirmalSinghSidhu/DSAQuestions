package nirmal.searchingSorting;

import java.util.Arrays;

public class SticklerThief {
    /*Stickler the thief wants to loot money from a society having n houses in a single line.
    He is a weird person and follows a certain rule when looting the houses. According to the
    rule, he will never loot two consecutive houses. At the same time, he wants to maximize
    the amount he loots. The thief knows which house has what amount of money but is unable
    to come up with an optimal looting strategy. He asks for your help to find the maximum
     money he can get if he strictly follows the rule. Each house has a[i]amount of money
     present in it.

     Input:
      n = 6
        a[] = {5,5,10,100,10,5}
        Output: 110
        Explanation: 5+100+5=110
        Example 2:

        Input:
        n = 3
        a[] = {1,2,3}
        Output: 4
        Explanation: 1+3=4
     */

    public static int maxSum(int []arr){
        int n = arr.length;
        return maxSumRec(arr,0,n);
    }

    private static int maxSumRec(int[] arr, int index, int n) {
        if(index >= n)
            return 0;
        int inclusion = arr[index] +maxSumRec(arr,index+2,n);
        int exclusion = maxSumRec(arr,index+1,n);

        return Math.max(inclusion,exclusion);
    }

    //memoization

    public static int maxSum2(int[] arr){
        int n = arr.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return maxSumMemoization(arr,0,n,dp);
    }

    private static int maxSumMemoization(int[] arr, int index, int n,int []dp) {
        if(index >= n)
            return 0;

        if(dp[index] != -1){
            return dp[index];
        }

        // recursive case: compute the maximum sum by either skipping the current element or including it
        int inclusion = arr[index] +maxSumMemoization(arr,index+2,n,dp);
        int exclusion = maxSumMemoization(arr,index+1,n,dp);

        dp[index]= Math.max(inclusion,exclusion);
        return dp[index];
    }

    //greedy approach
    public static int maxSum3(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int inclusive = nums[0];
        int exclusive = 0;
        for (int i = 1; i < n; i++) {
            int temp = inclusive;
            inclusive = Math.max(inclusive, exclusive + nums[i]);
            exclusive = temp;
        }
        return inclusive;
    }





    public static void main(String[] args) {
        // Creating the array
        int[] arr = { 5, 5, 10, 100, 10, 5 };

        // Function call
        System.out.println(maxSum3(arr));
    }
}
