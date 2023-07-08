package nirmal.searchingSorting;

public class SearchDifferByK {

    public static int search(int[] nums, int target , int k){
        int i = 0;
        while(i < nums.length){
            if(nums[i] == target){
                return i;
            }
            i = i + Math.max(1,Math.abs(nums[i]-target)/k);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 5, 7, 7, 6};
        int target = 6;
        int k = 2;
        int index = search(nums, target, k);
        System.out.println("Index: " + index);
    }
}
