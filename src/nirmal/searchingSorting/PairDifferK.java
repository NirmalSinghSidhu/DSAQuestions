package nirmal.searchingSorting;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class PairDifferK {
    public static ArrayList<ArrayList<Integer>> findPair(int[] nums , int k){
        int n = nums.length;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for( int i = 0; i< n -1;i++){
            for(int j = i+1; j<n;j++){
                if(Math.abs(nums[i]-nums[j])==k){
                   ArrayList<Integer> res = new ArrayList<>();
                   res.add(nums[i]);
                   res.add(nums[j]);
                   ans.add(res);
                }
            }
        }
        return ans;
    }

    //hashset approach

    public static ArrayList<int[]> findPair2(int[] nums ,int k){
        HashSet<Integer> set = new HashSet<>();
        HashSet<int[]> temp = new HashSet<>();
        ArrayList<int[]> result = new ArrayList<>();
        for(int num : nums){
            if(set.contains(num-k)){
                int ans[] = new int[]{num-k,num};
                temp.add(ans);
            }
            else if(set.contains(num+k)){
                int ans[] = new int[]{num,num+k};
                temp.add(ans);
            }else{
                set.add(num);
            }
        }
        result.addAll(temp);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 6, 8, 4,10};
        int k = 2;
        ArrayList<ArrayList<Integer> > ans = findPair(nums, k);
        System.out.println("Pair with difference " + k + ": " + ans);

        ArrayList<int[]> ans1 = findPair2(nums,k);
        for(int[] arr: ans1){
            System.out.println(Arrays.toString(arr));
        }
    }
}
