package easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ReverseStringTest {

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
                // LeetCode
                Arguments.of("hello", "olleh"),
                Arguments.of("Hannah", "hannaH"),
                // Own
                Arguments.of("abcdefgh", "hgfedcba"),
                Arguments.of("some random string", "gnirts modnar emos")
        );
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    void reverseString(String str, String expected) {
        char[] chars = str.toCharArray();
        ReverseString.reverseString(chars);
        assertArrayEquals(expected.toCharArray(), chars);
    }
}