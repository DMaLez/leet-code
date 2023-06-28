package easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortedArrayTest {

    @Test
    void testMerge1() {
        int[] result = {1,2,2,3,5,6};
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        MergeSortedArray.mergeMPlusN(nums1, 3, nums2, 3);
        assertArrayEquals(result, nums1);
    }

    @Test
    void testMerge4() {
        int[] result = {1,2};
        int[] nums1 = {2,0};
        int[] nums2 = {1};
        MergeSortedArray.mergeMPlusN(nums1, 1, nums2, 1);
        assertArrayEquals(result, nums1);
    }

    @Test
    void testMerge9() {
        int[] result = {1,2,3,4,5,6};
        int[] nums1 = {4,0,0,0,0,0};
        int[] nums2 = {1,2,3,5,6};
        MergeSortedArray.mergeMPlusN(nums1, 1, nums2, 5);
        assertArrayEquals(result, nums1);
    }

    @Test
    void testMerge17() {
        int[] result = {1,2,3,4,5,6};
        int[] nums1 = {4,5,6,0,0,0};
        int[] nums2 = {1,2,3};
        MergeSortedArray.mergeMPlusN(nums1, 3, nums2, 3);
        assertArrayEquals(result, nums1);
    }

    @Test
    void testMerge55() {
        int[] result = {1,2,3,4,5,6};
        int[] nums1 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] nums2 = {-50,-50,-48,-47,-44,-44,-37,-35,-35,-32,-32,-31,-29,-29,-28,-26,-24,-23,-23,-21,-20,-19,-17,-15,-14,-12,-12,-11,-10,-9,-8,-5,-2,-2,1,1,3,4,4,7,7,7,9,10,11,12,14,16,17,18,21,21,24,31,33,34,35,36,41,41,46,48,48};
        MergeSortedArray.mergeMPlusN(nums1, 0, nums2, 63);
        assertArrayEquals(result, nums1);
    }

    @Test
    void testMergeWithEmptyNums2() {
        int[] result = {1};
        int[] nums1 = {1};
        int[] nums2 = {};
        MergeSortedArray.mergeMPlusN(nums1, 1, nums2, 0);
        assertArrayEquals(result, nums1);
    }

}