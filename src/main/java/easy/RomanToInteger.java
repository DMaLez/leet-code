package easy;

import java.util.*;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two ones added together.
 * 12 is written as XII, which is simply X + II. The number 27 is written as XXVII,
 * which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is
 * written as IV. Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX. There
 * are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 *
 * Constraints:
 * 1 <= s.length <= 15
 * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
 * It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 */
public class RomanToInteger {

    private static final Set<Character> VALID_SYMBOLS = Set.of('I', 'V', 'X', 'L', 'C', 'D', 'M');

    /**
     * Runtime: 4 ms, faster than 98.28% of Java online submissions for Roman to Integer.
     * Memory Usage: 41.9 MB, less than 99.78% of Java online submissions for Roman to Integer.
     */
    public static int romanToIntSinglePointer(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (i + 1 < s.length() && canBePlacedBefore(currentChar, s.charAt(i + 1))) {
                result += -mapRomanCharToInt(currentChar);
            }
            else {
                result += mapRomanCharToInt(currentChar);
            }

        }
        return result;
    }

    /**
     * Runtime: 8 ms, faster than 64.08% of Java online submissions for Roman to Integer.
     * Memory Usage: 45 MB, less than 76.27% of Java online submissions for Roman to Integer.
     */
    public static int romanToIntTwoPointers(String s) {
        if (s.length() == 1) return mapRomanCharToInt(s.charAt(0));

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar;
            char nextChar ;
            if (i == s.length() - 1) {
                currentChar = s.charAt(i);
                nextChar = currentChar;
            } else {
                currentChar = s.charAt(i);
                nextChar = s.charAt(i + 1);
            }
            if (canBePlacedBefore(currentChar, nextChar)) {
                result += mapRomanCharToInt(nextChar) ;
                i++;
            } else {
                result += mapRomanCharToInt(currentChar);
            }
        }
        return result;
    }

    private static boolean canBePlacedBefore(char firstChar, char nextChar) {
        switch (firstChar) {
            case 'I':
                return nextChar == 'V' || nextChar == 'X';
            case 'X':
                return nextChar == 'L' || nextChar == 'C';
            case 'C':
                return nextChar == 'D' || nextChar == 'M';
        }
        return false;
    }

    private static short mapRomanCharToInt(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: throw new IllegalArgumentException("Illegal Roman character");
        }
    }

    public static boolean isValidString(String s) {
        for (char c : s.toCharArray()) {
            if (!VALID_SYMBOLS.contains(c)) {
                return false;
            }
        }
        return true;
    }
}
