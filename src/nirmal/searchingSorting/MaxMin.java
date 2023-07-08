package nirmal.searchingSorting;

public class MaxMin {
    public static void findMaxMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int elm : nums) {
            if (elm < min) {
                min = elm;
            }
            if (elm > max) {
                max = elm;
            }
        }
        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
    }

    public static void findMinMax(int[] nums) {
        int n = nums.length;
        int min, max;
        int i;
        if (n % 2 == 0) {
            if (nums[0] > nums[1]) {
                max = nums[0];
                min = nums[1];
            } else {
                max = nums[1];
                min = nums[0];
            }
            i = 2;
        } else {
            max = nums[0];
            min = nums[0];
            i = 1;
        }
        while (i < n - 1) {
            if (nums[i] > nums[i + 1]) {
                if (nums[i] > max) {
                    max = nums[i];
                }
                if (nums[i + 1] < min) {
                    min = nums[i + 1];
                }
            } else {
                if (nums[i + 1] > max) {
                    max = nums[i + 1];
                }
                if (nums[i] < min) {
                    min = nums[i];
                }
            }
            i += 2;
        }
        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 1, 9, 2, 7};
        findMaxMin(nums);
    }
}
