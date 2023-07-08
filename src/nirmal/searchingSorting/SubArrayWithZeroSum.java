package nirmal.searchingSorting;

import java.util.HashMap;

public class SubArrayWithZeroSum {

    //brute force
    public static void printZeroSumSubArrays(int[] nums){
        int n = nums.length;
        for(int i = 0 ; i < n; i++){
            int sum  = 0;
            for(int j = i ; j< n; j++){
                sum += nums[j];

                if(sum == 0){
                    System.out.println("Sub array Found from Index "+i+" to "+j);
                }
            }
        }

    }

    //hashing

    public static void printZeroSumSubArray2(int[] nums){
        int n = nums.length;
        HashMap<Integer ,Integer> map = new HashMap<>();

        map.put(0,-1);
        int sum = 0;

        for(int i = 0; i < n ; i++){
            sum+=nums[i];

            if(map.containsKey(sum)){
                int startIndex = map.get(sum) + 1;
                int endIndex = i ;
                System.out.println("Sub array Found from Index "+startIndex+" to "+endIndex);

            }

            map.put(sum,i);
        }
    }


    public static void main(String[] args) {
        int[] nums = {4, 2, -3, -1, 0, 4};
        printZeroSumSubArrays(nums);
    }
}
