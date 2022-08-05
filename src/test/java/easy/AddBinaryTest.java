package easy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class AddBinaryTest {

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
                // LeetCode
                Arguments.of("11", "1", "100"),
                Arguments.of("1010", "1011", "10101"),
                // After fail
                Arguments.of("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
                        "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011",
                        "110111101100010011000101110110100000011101000101011001000011011000001100011110011010010011000000000"),
                // Own
                Arguments.of("0", "1", "1"),
                Arguments.of("0", "0", "0"),
                Arguments.of("1", "1", "10"),
                Arguments.of("10", "1000", "1010"),
                Arguments.of("11111", "11111", "111110"),
                Arguments.of("1010", "101", "1111"),
                Arguments.of("1001", "1011", "10100"),
                Arguments.of("111010", "11", "111101"),
                Arguments.of("11110", "11", "100001")
        );
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    void addBinaryFullAdderTest(String a, String b, String expected) {
        assertEquals(expected, AddBinary.addBinaryFullAdder(a, b));
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    void addBinaryTest(String a, String b, String expected) {
        assertEquals(expected, AddBinary.addBinaryStringBuilderWithoutLeadingZeroes(a, b));
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    void addBinaryBigIntegersTest(String a, String b, String expected) {
        assertEquals(expected, AddBinary.addBinaryBigIntegers(a, b));
    }

    @Test
    void addBinaryTest() {
        assertEquals("111101", AddBinary.addBinaryStringBuilderWithoutLeadingZeroes("111010", "11"));
    }

    @Test
    void addLeadingZerosTest() {
        assertEquals("0000011", AddBinary.addLeadingZeros("11", 5));
        assertEquals("123123", AddBinary.addLeadingZeros("123123", 0));
        assertEquals("0123", AddBinary.addLeadingZeros("123", 1));
    }

    @Test
    void testBigInput() {
        BigInteger bigInt1 = new BigInteger("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",2);
    }
}