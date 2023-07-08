package nirmal.searchingSorting;

public class FixedPoint {
    //Find a Fixed Point (Value equal to index) in a given array:
    public static int findFixedPoint(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                return i;
            }
        }
        return -1;
    }
    //binarySearch
    public static int findFixedPoint2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == mid) {
                return mid;
            } else if (nums[mid] < mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-3, -1, 1, 3, 5, 7};
        int fixedPoint = findFixedPoint(nums);
        System.out.println("Fixed Point: " + fixedPoint);
    }

}
