package easy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import easy.RemoveDuplicatesFromSortedArray;

class RemoveDuplicatesFromSortedArrayTest {

	private static final int GAP = RemoveDuplicatesFromSortedArray.GAP;
	
	private static Stream<Arguments> provideArguments() {
		return Stream.of(
				// LeetCode
				Arguments.of(new int[] {1,1,2}, new int[] {1,2,GAP}, 2),
				Arguments.of(new int[] {0,0,1,1,1,2,2,3,3,4}, new int[] {0,1,2,3,4,GAP,GAP,GAP,GAP,GAP}, 5),
				// Own
				Arguments.of(new int[0], new int[0], 0),
				Arguments.of(new int[] {1}, new int[] {1}, 1),
				Arguments.of(new int[] {0, 0}, new int[] {0, GAP}, 1),
				Arguments.of(new int[] {1,2}, new int[] {1,2}, 2)
				);
	}
	
	@ParameterizedTest
	@MethodSource("provideArguments")
	void removeDuplicatedTest(int[] nums, int[] expected, int expectedK) {
		int k = RemoveDuplicatesFromSortedArray.removeDuplicates(nums);
		assertArrayEquals(expected, nums);
		assertEquals(expectedK, k);
	}
	
	@Test
	void fillGapsTest() {
		int[] array = new int[] {0, GAP, 1, GAP, GAP, 2, GAP, 3, GAP, 4};
		RemoveDuplicatesFromSortedArray.fillGaps(array);
		assertArrayEquals(new int[] {0,1,2,3,4,GAP,GAP,GAP,GAP,GAP},  array);
	}

}
