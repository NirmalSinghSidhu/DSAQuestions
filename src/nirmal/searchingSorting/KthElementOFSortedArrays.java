package nirmal.searchingSorting;

import java.util.Arrays;

public class KthElementOFSortedArrays {
    public static int findKthElement(int[] nums1, int[] nums2, int k) {
        int[] merged = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, merged, 0, nums1.length);
        System.arraycopy(nums2, 0, merged, nums1.length, nums2.length);
        Arrays.sort(merged);
        return merged[k - 1];
    }

    // merge and Select

    public static int findKthElement2(int[] nums1, int[] nums2,int k){
        int n1 = nums1.length;
        int n2 = nums2.length;

        int  i = 0, j = 0, count  = 0;
        int kthElement = 0;

        while (i < n1 && j < n2){
            if(nums1[i] <= nums2[j]){
                kthElement = nums1[i++];
            }else{
                kthElement = nums2[j++];
            }
            count++;
            if(count == k){
                return kthElement;
            }
        }

        while (i < n1){
            kthElement = nums1[i++];
            count++;
            if(count == k){
                return kthElement;
            }
        }

        while (i < n2){
            kthElement = nums2[i++];
            count++;
            if(count == k){
                return kthElement;
            }
        }

        return kthElement;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 7};
        int[] nums2 = {2, 4, 6, 8};
        int k = 3;
        int kthElement = findKthElement2(nums1, nums2, k);
        System.out.println("Kth Element: " + kthElement);
    }
}
