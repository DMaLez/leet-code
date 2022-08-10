package easy;

/**
 * Given an integer array nums and an integer val, remove all occurrences of val
 * in nums in-place. The relative order of the elements may be changed.
 *
 * Since it is impossible to change the length of the array in some languages,
 * you must instead have the result be placed in the first part of the array nums.
 * More formally, if there are k elements after removing the duplicates, then
 * the first k elements of nums should hold the final result. It does not matter
 * what you leave beyond the first k elements.
 *
 * Return k after placing the final result in the first k slots of nums.
 *
 * Do not allocate extra space for another array. You must do this by modifying
 * the input array in-place with O(1) extra memory.
 *
 * Constraints:
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 50
 * 0 <= val <= 100
 */
public class RemoveElement {

    public static final int GAP = Integer.MIN_VALUE;

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Element.
     * Memory Usage: 42.8 MB, less than 25.85% of Java online submissions for Remove Element.
     */
    public static int removeElement(int[] nums, int val) {
        int i = 0, indexOfLastGap = nums.length - 1;
        while (i < nums.length) {
            if (nums[i] == val) {
                nums[i] = nums[indexOfLastGap];
                nums[indexOfLastGap] = Integer.MIN_VALUE;
                indexOfLastGap--;
            } else {
                i++;
            }
        }
        return indexOfLastGap + 1;
    }


    /**
     * Runtime: 1 ms, faster than 35.63% of Java online submissions for Remove Element.
     * Memory Usage: 42.7 MB, less than 35.25% of Java online submissions for Remove Element.
     */
    public static int removeElementWithFillGaps(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                nums[i] = Integer.MIN_VALUE;
                k++;
            }
        }
        fillGaps(nums);
        return nums.length - k;
    }

    public static void fillGaps(int[] nums) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[i] == Integer.MIN_VALUE) {
                if (nums[j] != Integer.MIN_VALUE) {
                    nums[i] = nums[j];
                    nums[j] = Integer.MIN_VALUE;
                    i++;
                }
            } else {
                i++;
            }
            j++;
        }
    }

}
