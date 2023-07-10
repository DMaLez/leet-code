package medium;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GenerateParenthesesTest {

    public static Stream<Arguments> provideArguments() {
        return Stream.of(
                // LeetCode
                Arguments.of(3, List.of("((()))","(()())","(())()","()(())","()()()")),
                Arguments.of(1, List.of("()")),
                // Own
                Arguments.of(2, List.of("(())", "()()"))
        );
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    void testGenerateParenthesis(int n, List<String> expected) {
        assertArrayEquals(expected.stream().toArray(), GenerateParentheses.generateParenthesis(n).stream().toArray());
    }

    @Test
    void testValidString() {
        assertTrue(GenerateParentheses.validString("()()"));
        assertTrue(GenerateParentheses.validString("((()))"));
        assertTrue(GenerateParentheses.validString("()(())()"));
        assertFalse(GenerateParentheses.validString("(("));
        assertFalse(GenerateParentheses.validString("(()))"));
        assertFalse(GenerateParentheses.validString(")"));
    }

}