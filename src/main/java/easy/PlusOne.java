package easy;

/**
 * You are given a large integer represented as an integer array digits,
 * where each digits[i] is the ith digit of the integer.
 * The digits are ordered from most significant to least significant in
 * left-to-right order. The large integer does not contain any leading 0's.
 *
 * Increment the large integer by one and return the resulting array of digits.
 *
 * Constraints:
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * digits does not contain any leading 0's.
 */
public class PlusOne {

    public static int[] plusOneFromDiscussion(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--){
            if(++digits[i] != 10) return digits;
            digits[i] = 0;
        }
        int [] res = new int[digits.length + 1];

        res[0] = 1;
        return res;
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Plus One.
     * Memory Usage: 42.3 MB, less than 63.58% of Java online submissions for Plus One.
     */
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
                if (i == 0) {
                    return createNewArray(digits);
                }
            } else {
                digits[i]++;
                return digits;
            }
        }
        return digits;
    }

    public static int[] createNewArray(int[] digits) {
        int[] newArray = new int[digits.length + 1];
        newArray[0] = 1;
        System.arraycopy(digits, 0, newArray, 1, digits.length);
        return newArray;
    }

    public static int[] plusOneConvertToInt(int[] digits) {
        int resultNumber = convertDigitsArrayToInt(digits) + 1;
        String resultString = String.valueOf(resultNumber);
        int[] result = new int[resultString.length()];
        for (int i = 0; i < resultString.length(); i++) {
            result[i] = Character.getNumericValue(resultString.charAt(i));
        }
        return result;
    }

    public static int convertDigitsArrayToInt(int[] digits) {
        int result = 0;
        for (int i = digits.length - 1, pow = 0; i >= 0; i--, pow++) {
            result += digits[i] * Math.pow(10, pow);
        }
        return result;
    }
}
