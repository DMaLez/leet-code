package easy;

import java.math.BigInteger;

/**
 * Given two binary strings a and b, return their sum as a binary string.
 *
 * Constraints:
 * 1 <= a.length, b.length <= 10^4
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 */
public class AddBinary {

    private static boolean carry = false;

    public static String addBinaryFullAdder(String a, String b) {
        carry = false;
        int length = Math.max(a.length(), b.length());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            boolean boolA = getBitByIndexFromBack(a, i);
            boolean boolB = getBitByIndexFromBack(b, i);
            boolean result = fullAdd(
                    boolA, boolB
                    );

            char digit = result ? '1' : '0';
            sb.insert(0, digit);
        }
        if (carry) {
            sb.insert(0, '1');
        }
        return sb.toString();
    }

    private static boolean getBitByIndexFromBack(String string, int indexFromBack) {
        if (indexFromBack >= string.length()) {
            return false;
        }
        return string.charAt(string.length() - indexFromBack - 1) == '1';
    }

    public static boolean fullAdd(boolean a, boolean b) {
        boolean aXorB = a ^ b;
        boolean carryOut = (a && b) || (aXorB && carry);
        boolean sum = aXorB ^ carry;
        carry = carryOut;
        return sum;
    }

    /**
     * Runtime: 3 ms, faster than 68.55% of Java online submissions for Add Binary.
     * Memory Usage: 42.7 MB, less than 67.28% of Java online submissions for Add Binary.
     */
    public static String addBinaryStringBuilderWithoutLeadingZeroes(String a, String b) {
        StringBuilder sb = new StringBuilder();
        String biggerString;
        String smallerString;
        if (a.length() > b.length()) {
            biggerString = a;
            smallerString = b;
        } else {
            biggerString = b;
            smallerString = a;
        }

        boolean carry = false;
        for (int i = smallerString.length() - 1, j = biggerString.length() - 1; i >= 0; i--, j--) {
            char charA = biggerString.charAt(j);
            char charB = smallerString.charAt(i);

            if (charA == '0' && charB == '0') {
                sb.insert(0, carry ? '1' : '0');
                carry = false;
            } else if (charA == '1' && charB == '1') {
                sb.insert(0, carry ? '1' : '0');
                carry = true;
            } else {
                sb.insert(0, carry ? '0' : '1');
            }
        }

        for (int i = biggerString.length() - smallerString.length() - 1; i >= 0; i--) {
            char charA = biggerString.charAt(i);
            if (carry && charA == '1') {
                sb.insert(0, '0');
            } else if (carry && charA == '0') {
                sb.insert(0, '1');
                carry = false;
            } else {
                sb.insert(0, charA);
            }
        }
        if (carry) {
            sb.insert(0, '1');
        }
        return sb.toString();
    }

    /**
     * Runtime: 9 ms, faster than 20.46% of Java online submissions for Add Binary.
     * Memory Usage: 42.9 MB, less than 53.98% of Java online submissions for Add Binary.
     */
    public static String addBinaryBigIntegers(String a, String b) {
        BigInteger a1 = new BigInteger(a, 2);
        BigInteger a2 = new BigInteger(b, 2);
        System.out.println(a1.add(a2).toString(2));
        return a1.add(a2).toString(2);
    }

    /**
     * Runtime: 4 ms, faster than 45.57% of Java online submissions for Add Binary.
     * Memory Usage: 42.4 MB, less than 82.12% of Java online submissions for Add Binary.
     */
    public static String addBinaryStringBuilderMemoryOptimized(String a, String b) {
        StringBuilder sb = new StringBuilder();
        if (a.length() < b.length()) {
            a = addLeadingZeros(a, b.length() - a.length());
        } else if (a. length() > b.length()) {
            b = addLeadingZeros(b, a.length() - b.length());
        }

        boolean carry = false;
        for (int i = a.length() - 1; i >= 0; i--) {
            boolean boolA = a.charAt(i) == '1';
            boolean boolB = b.charAt(i) == '1';
            if (!boolA && !boolB) {
                sb.insert(0, carry ? '1' : '0');
                carry = false;
            } else if (boolA && boolB) {
                sb.insert(0, carry ? '1' : '0');
                carry = true;
            } else {
                sb.insert(0, carry ? '0' : '1');
            }
        }

        if (carry) {
            sb.insert(0, '1');
        }

        return sb.toString();
    }

    /**
     * Runtime: 3 ms, faster than 68.55% of Java online submissions for Add Binary.
     * Memory Usage: 42.9 MB, less than 53.98% of Java online submissions for Add Binary.
     */
    public static String addBinaryStringBuilder(String a, String b) {
        StringBuilder sb = new StringBuilder();
        if (a.length() < b.length()) {
            a = addLeadingZeros(a, b.length() - a.length());
        } else if (a. length() > b.length()) {
            b = addLeadingZeros(b, a.length() - b.length());
        }

        boolean carry = false;
        for (int i = a.length() - 1; i >= 0; i--) {
            char charA = a.charAt(i);
            char charB = b.charAt(i);
            if (charA == '0' && charB == '0') {
                sb.insert(0, carry ? '1' : '0');
                carry = false;
            } else if (charA == '1' && charB == '1') {
                sb.insert(0, carry ? '1' : '0');
                carry = true;
            } else {
                sb.insert(0, carry ? '0' : '1');
            }
        }

        if (carry) {
            sb.insert(0, '1');
        }

        return sb.toString();
    }

    public static String addLeadingZeros(String a, int number) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number; i++) {
            sb.append('0');
        }
        return sb + a;
    }


}
