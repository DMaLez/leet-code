package easy;

import commons.Printer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LongestCommonPrefixTest {

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
                // LeetCode
                Arguments.of(new String[] {"flower","flow","flight"}, "fl"),
                Arguments.of(new String[] {"dog","racecar","car"}, ""),
                // Own
                Arguments.of(new String[] {"dog"}, "dog"),
                Arguments.of(new String[] {"apple",  "apricot", "apache"}, "ap"),
                Arguments.of(new String[] {"aaaaabbb",  "aaaaabbb", "aaaaabbb"}, "aaaaabbb"),
                Arguments.of(new String[] {"a",  "ab", "abc"}, "a")
        );
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    void longestCommonPrefixLoopsTest(String[] strs, String expected) {
        assertEquals(expected, LongestCommonPrefix.longestCommonPrefixLoops(strs));
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    void longestCommonPrefixXorTest(String[] strs, String expected) {
        assertEquals(expected, LongestCommonPrefix.longestCommonPrefixXor(strs));
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    void longestCommonPrefixlongestCommonPrefixSubstringTest(String[] strs, String expected) {
        assertEquals(expected, LongestCommonPrefix.longestCommonPrefixSubstring(strs));
    }

}
