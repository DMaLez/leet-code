package easy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static easy.MergeTwoSortedLists.mergeTwoListsBadWrapper;
import static easy.MergeTwoSortedLists.mergeTwoListsWrapper;
import static easy.MergeTwoSortedLists.toList;
import static easy.MergeTwoSortedLists.toArray;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MergeTwoSortedListsTest {

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
                // LeetCode
                Arguments.of(new int[]{1,2,4}, new int[]{1,3,4}, new int[]{1,1,2,3,4,4}),
                Arguments.of(new int[]{}, new int[]{}, new int[]{}),
                Arguments.of(new int[]{}, new int[]{0}, new int[]{0}),
                // Own
                Arguments.of(new int[]{4,6,8,10}, new int[]{1,2,3,5,7,9}, new int[]{1,2,3,4,5,6,7,8,9,10})
        );
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    void mergeTwoListsTest(int[] list1, int[] list2, int[] expected) {
        assertArrayEquals(expected, mergeTwoListsWrapper(list1, list2));
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    void mergeTwoListsNaiveTest(int[] list1, int[] list2, int[] expected) {
        assertArrayEquals(expected, toArray(mergeTwoListsBadWrapper(list1, list2)));
    }

    @Test
    void mergeTwoLists() {
        assertArrayEquals(new int[]{1,1,2,3,4,4}, mergeTwoListsWrapper(new int[]{1,2,4}, new int[]{1,3,4}) );
    }

    @Test
    void listTest() {
        int[] array= new int[] {1,2,3};
        ListNode list = toList(array);
        assertArrayEquals(array, toArray(list));
    }


}