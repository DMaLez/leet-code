package easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ClimbingStairsTest {

    public static Stream<Arguments> provideArguments() {
        return Stream.of(
                // LeetCode
                Arguments.of(2, 2),
                Arguments.of(3, 3),
                // Own
                Arguments.of(5, 4),
                Arguments.of(8, 5),
                Arguments.of(13, 6),
                Arguments.of(1_134_903_170, 44)
        );
    }

    @ParameterizedTest
    void testClimbStairs(int expected, int n) {
        assertEquals(expected, ClimbingStairs.climbStairsSolutionFromLeetCodeWithLessMemory(n));
        assertEquals(expected, ClimbingStairs.climbStairsSolutionFromLeetCode(n));
        assertEquals(expected, ClimbingStairs.climbStairs(n));
    }

}