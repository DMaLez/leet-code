package easy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ValidAnagramTest {

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
                // LeetCode
                Arguments.of("anagram", "nagaram", true),
                Arguments.of("rat", "car", false),
                // Own
                Arguments.of("aaab", "baaa", true),
                Arguments.of("abcdefghijklmn", "nmlkjihgfedcba", true),
                Arguments.of("sobaka", "psina", false),
                Arguments.of("aaaaaaaaabbbb", "aaaaaaaaabbba", false),
                Arguments.of("abcdefghijklmnopqrstuvwxyz", "zyxwvutsrqponmlkjihgfedcba", true)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    void isAnagramSortTest(String s, String t, boolean expected) {
        assertEquals(expected, ValidAnagram.isAnagramSort(s, t));
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    void isAnagramArrayTest(String s, String t, boolean expected) {
        assertEquals(expected, ValidAnagram.isAnagramArray(s, t));
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    void isAnagramHashMapTest(String s, String t, boolean expected) {
        assertEquals(expected, ValidAnagram.isAnagramHashMap(s, t));
    }

    @Test
    void isAnagramHashMapTest() {
        assertEquals(false, ValidAnagram.isAnagramHashMap("rata", "cara"));
    }

    @Test
    void isAnagramArrayTest() {
        assertEquals(false, ValidAnagram.isAnagramArray("rat", "car"));
    }
}