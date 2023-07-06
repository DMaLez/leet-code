package easy;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.*;

class FindTheDifferenceTest {

    @Test
    void testFindDifferenceXOR() {
        assertions(FindTheDifference::findTheDifferenceXOR);
    }

    @Test
    void testFindDifferenceMap() {
        assertions(FindTheDifference::findTheDifferenceMap);
    }

    @Test
    void testFindDifferenceVector() {
        assertions(FindTheDifference::findTheDifferenceArray);
    }

    @Test
    void testFindDifferenceSort() {
        assertions(FindTheDifference::findTheDifferenceSort);
    }

    void assertions(BiFunction<String, String, Character> func) {
        assertEquals('y', func.apply("", "y"));
        assertEquals('e', func.apply("abcd", "abcde"));
        assertEquals('a', func.apply("a", "aa"));
        assertEquals('e', func.apply("abcdef", "fdeaecb"));
    }
}