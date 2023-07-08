package nirmal.searchingSorting;

import java.util.Arrays;

public class TripletsLessThanK {

    //Brute Force Approach
    public static int countTriplets(int[] nums, int target) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] < target) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    //Sorting + Two Pointer
    public static int countTriplets2(int[] nums,int target){
        int n = nums.length;
        Arrays.sort(nums);
        int count = 0;

        for(int i = 0; i < n - 2; i++){
            int left = i+1;
            int right = n - 1;

            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum < target){
                    count += right - left;
                    left++;
                }else{
                    right--;
                }
            }
        }
       return count;
    }

        public static void main(String[] args) {
            int[] nums = {2, 3, 1, 4, 7, 5};
            int target = 8;
            int tripletCount = countTriplets(nums, target);
            System.out.println("Count of triplets with sum smaller than " + target + ": " + tripletCount);
        }

}
