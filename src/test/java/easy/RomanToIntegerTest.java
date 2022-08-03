package easy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RomanToIntegerTest {

    private static Stream<Arguments> provideRomans() {
        return Stream.of(
                // Leetcode
                Arguments.of("III", 3),
                Arguments.of("LVIII", 58),
                Arguments.of("MCMXCIV", 1994),
                // Own
                Arguments.of("M", 1000),
                Arguments.of("X", 10),
                Arguments.of("XII", 12),
                Arguments.of("MCMXCI", 1991),
                Arguments.of("MMMCMXCIX", 3999),
                Arguments.of("CMLXXXVII", 987),
                Arguments.of("MMMCIX", 3109),
                Arguments.of("MMCCCXXXIII", 2333),
                Arguments.of("MCXI", 1111),
                Arguments.of("MMCDXXII", 2422),
                Arguments.of("MMMCDXXVI", 3426)
        );
    }

    @ParameterizedTest
    @MethodSource("provideRomans")
    void romanToIntTest(String s, int expected) {
        assertEquals(expected, RomanToInteger.romanToIntSinglePointer(s));
    }

    @Test
    void romanToIntTest() {
        assertEquals(1991, RomanToInteger.romanToIntSinglePointer("MCMXCI"));
    }

    private static Stream<Arguments> provideRomanStrings() {
        return Stream.of(
                Arguments.of("II", true),
                Arguments.of("XX", true),
                Arguments.of("XVI", true),
                Arguments.of("CM", true),
                Arguments.of("MMDCXCVIII", true),
                Arguments.of("CCCLXVII", true),
                Arguments.of("ARRAY", false),
                Arguments.of("CCCLXV11", false),
                Arguments.of("CM ", false),
                Arguments.of("")
        );
    }

    @ParameterizedTest
    @MethodSource("provideRomanStrings")
    void isValidStringTest(String romanNumberString, boolean expected) {
        assertEquals(expected, RomanToInteger.isValidString(romanNumberString));
    }
}