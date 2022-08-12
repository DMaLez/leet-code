package easy;

/**
 * Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
 *
 * Constraints:
 * The input must be a binary string of length 32.
 */
public class NumberOf1Bits {


    /**
     * Runtime: 1 ms, faster than 87.00% of Java online submissions for Number of 1 Bits.
     * Memory Usage: 41.9 MB, less than 11.46% of Java online submissions for Number of 1 Bits.
     */
    public static int hammingWeightOwn(int n) {
        int numberOf1Bits = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                numberOf1Bits++;
            }
            n = n >> 1;
        }
        return numberOf1Bits;
    }

    /**
     * Runtime: 1 ms, faster than 87.00% of Java online submissions for Number of 1 Bits.
     * Memory Usage: 41 MB, less than 64.86% of Java online submissions for Number of 1 Bits.
     */
    public static int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
