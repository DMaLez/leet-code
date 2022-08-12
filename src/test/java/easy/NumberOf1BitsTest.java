package easy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class NumberOf1BitsTest {

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
                // LeetCode
              Arguments.of(11, 3),
              Arguments.of(128, 1),
              Arguments.of(-3, 31),
              // Own
              Arguments.of(-25420, 24),
              Arguments.of(32367, 12)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    void hammingWeightTest(int n, int expected) {
        assertEquals(expected, NumberOf1Bits.hammingWeightOwn(n));
    }

}