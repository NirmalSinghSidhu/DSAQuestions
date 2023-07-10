package nirmal.searchingSorting;
import java.util.*;

public class SortBigArray {
       public static void threeWayQuickSort(int[] nums, int low, int high) {
            if (low < high) {
                int[] pivots = partition(nums, low, high);

                threeWayQuickSort(nums, low, pivots[0] - 1);
                threeWayQuickSort(nums, pivots[1] + 1, high);
            }
        }

        public static int[] partition(int[] nums, int low, int high) {
            int pivot = nums[low];
            int lt = low;
            int gt = high;
            int i = low + 1;

            while (i <= gt) {
                if (nums[i] < pivot) {
                    swap(nums, i, lt);
                    i++;
                    lt++;
                } else if (nums[i] > pivot) {
                    swap(nums, i, gt);
                    gt--;
                } else {
                    i++;
                }
            }

            return new int[]{lt, gt};
        }

        public static void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        public static void main(String[] args) {
            int[] nums = {2, 3, 1, 3, 1, 2, 2, 1, 3};
            threeWayQuickSort(nums, 0, nums.length - 1);
            System.out.println("Sorted Array: " + Arrays.toString(nums));
        }
}
