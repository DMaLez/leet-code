package easy;

import java.util.Arrays;

public class MergeSortedArray {

    /**
     * Runtime 0 ms Beats 100%
     * Memory 41.6 MB Beats 42.54%
     */
    public static void mergeMPlusN(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int posOfLastZero = m + n - 1;

        while (j >= 0) {
            if (i < 0 || nums2[j] >= nums1[i]) {
                nums1[posOfLastZero] = nums2[j];
                j--;
            } else {
                nums1[posOfLastZero] = nums1[i];
                i--;
            }
            posOfLastZero--;
        }

    }

    /**
     * Runtime 1 ms Beats 34.56%
     * Memory 41.4 MB Beats 78.72%
     */
    public static void mergeWithSort(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[i + m] = nums2[i];
        }
        Arrays.sort(nums1);
    }

}
