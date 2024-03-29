package easy;

import com.sun.source.tree.Tree;

import java.util.Set;
import java.util.TreeSet;

/**
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place
 * such that each unique element appears only once. The relative order of the elements should be kept the same.
 * Since it is impossible to change the length of the array in some languages, you must instead have the result 
 * be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates,
 * then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 * 
 * Return k after placing the final result in the first k slots of nums.
 * 
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Constraints:
 * 1 <= nums.length <= 3 * 10^4
 * -100 <= nums[i] <= 100
 * nums is sorted in non-decreasing order.
 */
public class RemoveDuplicatesFromSortedArray {

	public static final int GAP = Integer.MIN_VALUE;

	/**
	 * Runtime 6 ms Beats 8.45%
	 * Memory 44 MB Beats 66.54%
	 */
	public static int removeDuplicatesSet(int[] nums) {
		TreeSet<Integer> nonDuplicateNumbers = new TreeSet<>();
		for (int i = 0; i < nums.length; i++) {
			nonDuplicateNumbers.add(nums[i]);
		}
		int k = 0;
		for (int i : nonDuplicateNumbers) {
			nums[k++] = i;
		}
		return k;
	}

	/**
	 * Runtime 1 ms Beats 99.35%
	 * Memory 45.2 MB Beats 5.16%
	 */
	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0) return 0;
		if (nums.length == 1) return 1;
		int i = 0, j = 1, k = 1;
		while (j < nums.length) {
			if (nums[i] == nums[j]) {
				nums[j] = Integer.MIN_VALUE;
			} else {
				i = j;
				k++;
			}
			j++;
		}
		fillGaps(nums);
		return k;
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
