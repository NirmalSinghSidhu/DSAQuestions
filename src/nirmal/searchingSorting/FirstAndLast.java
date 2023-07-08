package nirmal.searchingSorting;

public class FirstAndLast {
    public static int[] search(int[] nums,int target){
        int result[] = new int[]{-1,-1};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                result[0] = i;
                break;
            }
        }

        for (int i = nums.length -1; i >= 0; i--) {
            if (nums[i] == target) {
                result[1] = i;
                break;
            }
        }
        return result;
    }

    //binarySearch

    public static int[] search2(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int left = findLeftPosition(nums, target);
        if (left == -1) {
            return result;
        }
        int right = findRightPosition(nums, target);
        result[0] = left;
        result[1] = right;
        return result;
    }

    private static int findLeftPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[left] != target) {
            return -1;
        }
        return left;
    }
    private static int findRightPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 4, 4, 4, 5};
        int target = 4;
        int[] result = search2(nums, target);
        System.out.println("First Position: " + result[0]);
        System.out.println("Last Position: " + result[1]);
    }
}
