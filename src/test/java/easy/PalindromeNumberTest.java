package easy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeNumberTest {

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
                // LeetCode
                Arguments.of(121 , true),
                Arguments.of(-121 , false),
                Arguments.of(10 , false),
                // Own
                Arguments.of(100, false),
                Arguments.of(1, true),
                Arguments.of(12344321, true),
                Arguments.of(12121212, false),
                Arguments.of(Integer.MAX_VALUE, false),
                Arguments.of(110151011, true),
                Arguments.of(742247, true),
                Arguments.of(1331, true),
                Arguments.of(123454321, true),
                Arguments.of(123454421, false),
                Arguments.of(712247, false),
                Arguments.of(12331, false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    void isPalindromeUsingStringTest(int x, boolean expected) {
        assertEquals(expected, PalindromeNumber.isPalindromeUsingString(x));
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    void isPalindromeUsingModuleAndDivideTest(int x, boolean expected) {
        assertEquals(expected, PalindromeNumber.isPalindromeUsingModuleAndDivide(x));
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    void isPalindromeUsingModuleDivideAndArrayTest(int x, boolean expected) {
        assertEquals(expected, PalindromeNumber.isPalindromeUsingModuleDivideAndArray(x));
    }

}