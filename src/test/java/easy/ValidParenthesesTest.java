package easy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesesTest {

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
                // LeetCode
                Arguments.of("()", true),
                Arguments.of("()[]{}", true),
                Arguments.of("(]", false),
                // After fail
                Arguments.of("[", false),
                Arguments.of("]", false),
                // Own
                Arguments.of("([({}())]){}", true),
                Arguments.of("([({}()))){}", false),
                Arguments.of("[][][][][]", true),
                Arguments.of("{(){}[](){}[]}", true),
                Arguments.of("[(){}[](){}[]}", false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    void isValidStackBasedTest(String s, boolean expected) {
        assertEquals(expected, ValidParentheses.isValidStackBased(s));
    }
}