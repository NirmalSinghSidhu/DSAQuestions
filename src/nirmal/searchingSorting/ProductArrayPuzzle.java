package nirmal.searchingSorting;

import java.util.Arrays;

public class ProductArrayPuzzle {
    //Brute Force
    public static int[] getProductArray(int[] nums) {
        int n = nums.length;
        int[] product = new int[n];
        for (int i = 0; i < n; i++) {
            int p = 1;
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    p *= nums[j];
                }
            }
            product[i] = p;
        }
        return product;
    }

    //Prefix and suffix
    public static int[] getProductArray2(int[] nums) {
        int n = nums.length;
        int[] prefixProduct = new int[n];
        int[] suffixProduct = new int[n];
        int[] product = new int[n];

        prefixProduct[0] = 1;
        for (int i = 1; i < n; i++) {
            prefixProduct[i] = prefixProduct[i - 1] * nums[i - 1];
        }

        suffixProduct[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffixProduct[i] = suffixProduct[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            product[i] = prefixProduct[i] * suffixProduct[i];
        }

        return product;
    }




        public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int[] product = getProductArray(nums);
        System.out.println("Product Array: " + Arrays.toString(product));
    }
}

