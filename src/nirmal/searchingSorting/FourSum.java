package nirmal.searchingSorting;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class FourSum {

    //bad approach
    public static int[] findFourElements(int[] nums,int target){
        int n = nums.length;

        for(int i = 0 ; i < n - 3;i++){
            for(int j = i+1; j<n-2;j++){
                for(int k = j+1; k< n-1; k++){
                    for(int l = k+1;l<n;l++){
                        if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            return new int[]{nums[i],nums[j],nums[k],nums[l]};
                        }
                    }
                }
            }
        }
        return null;
    }

    //Using hashMap

    public static ArrayList<ArrayList<Integer>> findFourElements2(int[] nums,int target){
        int n = nums.length;
        HashMap<Integer,int[]> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++ ){
                int sum = nums[i]+nums[j];
                if(map.containsKey(sum)){
                   int pair[] = map.get(target-sum);
                    if (pair !=null && pair[0] != i && pair[0] != j && pair[1] != i && pair[1] != j) {
                        ArrayList<Integer> ans = new ArrayList<>();
                        ans.add(pair[0]);
                        ans.add(pair[1]);
                        ans.add(nums[i]);
                        ans.add(nums[j]);

                        result.add(ans);
                    }
                }
                map.put(sum,new int[]{i,j});
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {2, 7, 4, 0, 9, 5, 1, 3};
        int target = 20;
        System.out.println(Arrays.toString(findFourElements(nums,target)));
        System.out.println(findFourElements2(nums,target));
    }
}
