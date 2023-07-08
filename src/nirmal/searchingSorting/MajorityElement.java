package nirmal.searchingSorting;

import java.util.HashMap;

public class MajorityElement {
        public static int findMajorityElement(int[] nums) {
            int candidate = 0;
            int count = 0;
            for (int num : nums) {
                if (count == 0) {
                    candidate = num;
                    count = 1;
                } else if (candidate == num) {
                    count++;
                } else {
                    count--;
                }
            }
            return candidate;
        }

        //HashMap


       public static int findMajorityElement2(int[] nums){
           HashMap<Integer,Integer> map = new HashMap<>();

           int majorityCount = nums.length / 2;

           for(int num : nums){
               map.put(num,map.getOrDefault(num,0)+1);
               if(map.get(num)>majorityCount){
                   return num;
               }
           }

           return -1; // N0 majority element found
       }

        public static void main(String[] args) {
            int[] nums = {2, 2, 1, 1, 1, 2, 2};
            int majorityElement = findMajorityElement2(nums);
            System.out.println("Majority Element: " + majorityElement);
        }

}
