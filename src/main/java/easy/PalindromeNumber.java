package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer x, return true if x is palindrome integer.
 *
 * An integer is a palindrome when it reads the same backward as forward.
 *
 * For example, 121 is a palindrome while 123 is not.
 *
 * Constraints:
 * -2^31 <= x <= 2^31 - 1
 *
 * Follow up: Could you solve it without converting the integer to a string?
 */
public class PalindromeNumber {

    /**
     * Runtime: 3 ms, faster than 80.51% of Java online submissions for Palindrome Number.
     * Memory Usage: 42.7 MB, less than 32.79% of Java online submissions for Palindrome Number.
     */
    public static boolean isPalindromeUsingString(int x) {
        String numberAsStr = String.valueOf(x);
        for (int i = 0, j = numberAsStr.length() - 1; i < numberAsStr.length() / 2; i++, j--) {
            if (numberAsStr.charAt(i) != numberAsStr.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Runtime: 16 ms, faster than 41.79% of Java online submissions for Palindrome Number.
     * Memory Usage: 44.2 MB, less than 73.55% of Java online submissions for Palindrome Number.
     */
    public static boolean isPalindromeUsingModuleAndDivide(int x) {
        if (x < 0) return false;

        int base = 1;
        while (base < 1000000000) {
            if ((x / base) < 10) break;
            base *= 10;
        }

        while (x != 0) {
            // First digit = x / base
            // Last digit = x % 10
            if (x / base != x % 10) {
                return false;
            }
            x -= x / base * base;
            x /= 10;
            base /= 100;
        }
        return true;
    }

    public static boolean isPalindromeUsingModuleDivideAndArray(int x) {
        if (x < 0) return false;

        List<Integer> digits = new ArrayList<>(10);
        int numberOfDigits = 0;
        while (x != 0) {
            digits.add(x % 10);
            x /= 10;
            numberOfDigits++;
        }
        for (int i = 0, j = numberOfDigits - 1; i < numberOfDigits / 2; i++, j--) {
            if (digits.get(i) != digits.get(j)) {
//            if ((digits.get(i) ^ digits.get(j)) != 0) {
                return false;
            }
        }
        return true;
    }
}
