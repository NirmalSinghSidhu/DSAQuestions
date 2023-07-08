package nirmal.searchingSorting;

import java.util.Arrays;
import java.util.HashSet;

public class RepeatingMissingNumber {

    public static void findMissingAndRepeating(int []nums){
        Arrays.sort(nums);
        int repeating = -1;
        int missing = -1;

        for(int i = 0; i<nums.length-1;i++){
            if(nums[i] == nums[i+1]){
                repeating = nums[i];
            }
            else if(nums[i] + 1 !=nums[i+1]){
                missing = nums[i] + 1;
            }
        }

        System.out.println("Repeating number: " + repeating);
        System.out.println("Missing number: " + missing);
    }

    //hashSet
    public static void findMissingAndRepeating2(int[] nums){
        HashSet<Integer> set = new HashSet<>();

        int repeating = -1;
        int missing = -1;

        for(int num : nums){
            if(!set.add(num)){  //The add operator of the set class returns a boolean which is true
                // if the element (which is to be added) wasn't already there,
                // and false otherwise.
                repeating = num;
            }
        }

        for(int i = 1;i <= nums.length;i++){
            if(!set.contains(i)){
                missing = i;
                break;
            }
        }
        System.out.println("Repeating number: " + repeating);
        System.out.println("Missing number: " + missing);
    }
    public static void main(String[] args) {
        int[] nums = {4, 2, 3, 6, 2, 1};
        findMissingAndRepeating2(nums);
    }


}
