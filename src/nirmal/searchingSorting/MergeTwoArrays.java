package nirmal.searchingSorting;

import java.util.Arrays;

public class MergeTwoArrays {
    public static int[] mergeArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, merged, 0, nums1.length);
        System.arraycopy(nums2, 0, merged, nums1.length, nums2.length);
        Arrays.sort(merged);
        return merged;
    }

    public static int[] mergeArrays2(int[] nums1,int[]nums2){
        int m = nums1.length;
        int n = nums2.length;
        int[] merged = new int[m+n];

        int i = 0, j = 0 , k = 0;

        while(i<m && j <n){
            if(nums1[i]<=nums2[j]){
                merged[k++]=nums1[i++];
            }else{
                merged[k++]=nums2[j++];
            }
        }
        while (i < m) {
            merged[k++] = nums1[i++];
        }

        while (j < n) {
            merged[k++] = nums2[j++];
        }

        return merged;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 7};
        int[] nums2 = {2, 4, 6, 8};
        int[] merged = mergeArrays2(nums1, nums2);
        System.out.println("Merged Array: " + Arrays.toString(merged));
    }

}
