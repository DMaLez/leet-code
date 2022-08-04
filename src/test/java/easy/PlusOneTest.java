package easy;

import static commons.Utils.toArray;

import commons.Utils;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PlusOneTest {

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
                // Leetcode
                Arguments.of(new int[] {1,2,3}, new int[] {1,2,4}),
                Arguments.of(new int[] {4,3,2,1}, new int[] {4,3,2,2}),
                Arguments.of(new int[] {9}, new int[] {1,0}),
                // Own
                Arguments.of(new int[] {3,5,4,8,8}, new int[] {3,5,4,8,9}),
                Arguments.of(new int[] {4,9,8,1,6}, new int[] {4,9,8,1,7}),
                Arguments.of(new int[] {8,2,5,1,0}, new int[] {8,2,5,1,1}),
                Arguments.of(new int[] {6,2,5,8}, new int[] {6,2,5,9}),
                Arguments.of(new int[] {5,0,4,9,7,3,9}, new int[] {5,0,4,9,7,4,0}),
                Arguments.of(new int[] {9,9,9,9,9}, new int[] {1,0,0,0,0,0}),
                Arguments.of(new int[] {8,9,9}, new int[] {9,0,0})
        );
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    void plusOneTest(int[] digits, int[] expected) {
        assertArrayEquals(expected, PlusOne.plusOne(digits));
    }

    @Test
    void plusOneConvertToIntTest() {
        assertArrayEquals(toArray(1,2,3), PlusOne.plusOneConvertToInt(toArray(1, 2, 2)));
        assertArrayEquals(toArray(2), PlusOne.plusOneConvertToInt(toArray(1)));
        assertArrayEquals(toArray(3,5), PlusOne.plusOneConvertToInt(toArray(3, 4)));
        assertArrayEquals(toArray(1,0,2,1), PlusOne.plusOneConvertToInt(toArray(1,0,2,0)));
        assertArrayEquals(toArray(1,0,0,0), PlusOne.plusOneConvertToInt(toArray(9,9,9)));
    }

    private static Stream<Arguments> provideArgumentsForConvertDigitsArrayToIntTest() {
        return Stream.of(
                Arguments.of(new int[] {3,5,4,8,8}, 35488),
                Arguments.of(new int[] {4,9,8,1,6}, 49816),
                Arguments.of(new int[] {8,2,5,1,0}, 82510),
                Arguments.of(new int[] {6,2,5,8}, 6258),
                Arguments.of(new int[] {5,0,4,9,7,3,4}, 5049734)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForConvertDigitsArrayToIntTest")
    void convertDigitsArrayToIntTest(int[] digits, int expected) {
        assertEquals(expected, PlusOne.convertDigitsArrayToInt(digits));
    }

    @Test
    void convertDigitsArrayToIntTest() {
        assertEquals(123, PlusOne.convertDigitsArrayToInt(toArray(1,2,3)));
    }

    @Test
    void createNewArrayTest() {
        assertArrayEquals(toArray(1, 0, 0, 0), PlusOne.createNewArray(toArray(0,0,0)));
    }


}