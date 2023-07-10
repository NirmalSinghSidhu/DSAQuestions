package nirmal.searchingSorting;

public class PivotElementInRotatedSorted {

    public static int findPivot(int[] arr){
        int n = arr.length;
        int start = 0;
        int end = arr.length - 1;

        while( start < end){
            int mid = start + (end -start)/2;
            if(arr[mid] >arr[n-1]){
                start = mid+1;
            }else{
                end = mid;
            }
        }
        return arr[start];
    }

    public static int findPivot2(int[] arr){
        int start  = 0;
        int end = arr.length - 1;

        while( start < end){
            int mid = start + (end - start)/2;
            if(arr[mid] > arr[0]){
                start = mid + 1 ;
            }
            else{
                end = mid;
            }
        }
        return arr[end];
    }

    //LinearSearch

    public static int findPivot3(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return nums[i + 1];
            }
        }
        return nums[0];
    }
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7,8,0, 1, 2};
        int pivot = findPivot2(nums);
        System.out.println("Pivot element: " + pivot);
    }
}
