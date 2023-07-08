package nirmal.searchingSorting;

public class MinimumSwapsToSort {

    //Brute force
    public static int minimumSwaps(int[] nums){
        int n = nums.length;
        int swaps = 0;

        for(int i = 0; i < n - 1;i++){
            int minIndex = i;
            for(int j = i + 1; j < n;j++){
                if(nums[j] < nums[minIndex]){
                    minIndex = j;
                }
            }
            if(minIndex != i){
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
                swaps++;
            }
        }
        return swaps;
    }

    //using graph and Cycle detection
    
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 1};
        int minimumSwaps = minimumSwaps(nums);
        System.out.println("Minimum Swaps required: " + minimumSwaps);
    }

}
