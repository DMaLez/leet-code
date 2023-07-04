package easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MajorityElementTest {

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
                // LeetCode
                Arguments.of(3, new int[] {3,2,3}),
                Arguments.of(2, new int[] {2,2,1,1,1,2,2}),
                // Own
                Arguments.of(9, new int[] {9}),
                Arguments.of(5, new int[] {5, 5, 5, 5, 5, 1, 2, 3, 4})
        );
    }

    @MethodSource("provideArguments")
    @ParameterizedTest
    void majorityElementHashMap(int expected, int[] arr) {
        assertEquals(expected, MajorityElement.majorityElementHashMap(arr));
    }

    @MethodSource("provideArguments")
    @ParameterizedTest
    void majorityElementSorting(int expected, int[] arr) {
        assertEquals(expected, MajorityElement.majorityElementSorting(arr));
    }

}