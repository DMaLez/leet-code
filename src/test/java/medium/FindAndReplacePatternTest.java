package medium;

import commons.Printer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FindAndReplacePatternTest {

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
                // Leetcode
                Arguments.of(new String[]{"abc","deq","mee","aqq","dkd","ccc"}, "abb", List.of("mee", "aqq")),
                Arguments.of(new String[]{"a","b","c"}, "a", List.of("a","b","c")),
                // After fail
                Arguments.of(new String[]{"abc","cba","xyx","yxx","yyx"}, "abc", List.of("abc","cba")),
                Arguments.of( new String[]{"ktittgzawn","dgphvfjniv","gceqobzmis","alrztxdlah","jijuevoioe","mawiizpkub","onwpmnujos","zszkptjgzj","zwfvzhrucv","isyaphcszn"}, "zdqmjnczma", List.of()),
                // Own
                Arguments.of(new String[]{"xyz", "qwe", "asd", "bbz"}, "abc", List.of("xyz", "qwe", "asd")),
                Arguments.of(new String[]{"aa", "bb", "ax", "xa"}, "ac", List.of("ax", "xa")),
                Arguments.of(new String[]{"qqww", "wwqq", "asdf", "fdas"}, "aabb", List.of("qqww", "wwqq")),
                Arguments.of(new String[]{"aabcc", "qqwee", "ppoii", "mmnjj"}, "aabcc", List.of("aabcc", "qqwee", "ppoii", "mmnjj"))

        );
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    void findAndReplacePatternTest(String[] words, String pattern, List<String> expected) {
        assertArrayEquals(expected.toArray(new String[0]), FindAndReplacePattern.findAndReplacePattern(words, pattern).toArray(new String[0]));
    }

    private static Stream<Arguments> provideArgumentsForMappingExists() {
        return Stream.of(
                Arguments.of("mee", "abb", true),
                Arguments.of("aqq", "abb", true),
                Arguments.of("ccc", "abb", false),
                Arguments.of("a", "a", true),
                Arguments.of("b", "a", true),
                Arguments.of("c", "a", true),
                Arguments.of("cba", "abc", true),
                Arguments.of("xyx", "abc", false),
                Arguments.of("yyx", "abc", false),
                Arguments.of("mawiizpkub", "zdqmjnczma", false),
                Arguments.of("jijuevoioe", "zdqmjnczma", false),
                Arguments.of("gceqobzmis", "zdqmjnczma", false),
                Arguments.of("dgphvfjniv", "zdqmjnczma", false),
                Arguments.of("ktittgzawn", "zdqmjnczma", false),
                Arguments.of("fdas", "aabb", false),
                Arguments.of("qqww", "aabb", true),
                Arguments.of("wwqq", "aabb", true)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForMappingExists")
    void mappingExistsTest(String word, String pattern, boolean expected) {
        assertEquals(expected, FindAndReplacePattern.bijectiveMappingExistsSingleArrray(word, pattern));
    }

    @Test
    void mappingExistsTest() {
        assertEquals(false, FindAndReplacePattern.bijectiveMappingExistsSingleArrray("wwqq", "aabb"));
    }

    @Test
    void findAndReplacePatternTest() {
        assertArrayEquals(List.of("a","b","c").toArray(new String[0]), FindAndReplacePattern.findAndReplacePattern(new String[] {"a","b","c"}, "a").toArray(new String[0]));
    }

    private static Stream<Arguments> provideArgumentsForBuildPatternString() {
        return Stream.of(
                Arguments.of("a", "1"),
                Arguments.of("aa", "2"),
                Arguments.of("aaabcbb", "3112+"),
                Arguments.of("abccabb", "1121+2+"),
                Arguments.of("aaaaaaaaaaaaaaaaaaaabbaaccc", "2022+3"),
                Arguments.of("xyx", "111+")
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForBuildPatternString")
    void buildPatternStringTest(String word, String expected) {
        assertEquals(expected, FindAndReplacePattern.buildCharactersCountingString(word));
    }

    @Test
    void buildPatternStringTest() {
        assertEquals("111+", FindAndReplacePattern.buildCharactersCountingString("xyx"));
    }

}
