package easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static easy.RemoveElement.removeElement;
import static org.junit.jupiter.api.Assertions.*;
import static easy.RemoveElement.GAP;

class RemoveElementTest {

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
                // LeetCode
                Arguments.of(new int[] {3,2,2,3}, 3, new int[] {2,2,GAP,GAP}, 2),
                Arguments.of(new int[] {0,1,2,2,3,0,4,2}, 2, new int[] {0,1,4,0,3,GAP,GAP,GAP}, 5),
                // Own
                Arguments.of(new int[0], 2, new int[0], 0),
                Arguments.of(new int[] {1}, 2, new int[] {1}, 1),
                Arguments.of(new int[] {1}, 1, new int[] {GAP}, 0),
                Arguments.of(new int[] {2,2,2,2}, 2, new int[]{GAP,GAP,GAP,GAP},0),
                Arguments.of(new int[] {2,1,2,3,2},2, new int[] {3,1,GAP,GAP,GAP}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    void removeElementTest(int[] nums, int value, int[] expected, int expectedK) {
        int k = removeElement(nums, value);
        assertArrayEquals(expected, nums);
        assertEquals(expectedK, k);
    }

}