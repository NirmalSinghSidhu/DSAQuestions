package nirmal.searchingSorting;

public class SearchInRotatedSortedArray {

    //Linear Search
    public static int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    //binarySearch
    public static int search2(int[] nums , int target){
        int start  = 0 ;
        int end = nums.length-1;

        while (start <= end){
            int mid = start +(end -start)/2;
            if(nums[mid]== target){
                return mid +1;
            }
            else if( nums[mid] >= nums[start] ){
                if(target >= nums[start] && target < nums[mid]){
                   end = mid -1;
                }
                else{
                    start = mid +1;
                }
            }else{
                if(target > nums[mid] && target <= nums[end]){
                    start = mid+1;
                }else{
                    end = mid -1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int index = search2(nums, target);
        System.out.println("Index: " + index);
    }
}
