package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    /**
     * Runtime 3 ms Beats 51.54%
     * Memory 48.9 MB Beats 12.68%
     */
    public static int majorityElementSortingFast(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
    /**
     * Runtime 4 ms Beats 45.66%
     * Memory 49 MB Beats 6.87%
     */
    public static int majorityElementSorting(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int majority = nums.length / 2 + 1;
        Arrays.sort(nums);
        short currentMajority = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                currentMajority++;
                if (currentMajority == majority) return nums[i];
            } else {
                currentMajority = 1;
            }
        }
        return -1;
    }

    /**
     * Runtime 13 ms Beats 32.78%
     * Memory 46.3 MB Beats 87.84%
     */
    public static int majorityElementHashMap(int[] nums) {
        Map<Integer, Short> countMap = new HashMap<>();
        for (int i : nums) {
            countMap.compute(i, (k, v) -> v == null ? 1 : ++v);
            if (countMap.get(i) > nums.length / 2) return i;
        }
        return -1;
    }
}
