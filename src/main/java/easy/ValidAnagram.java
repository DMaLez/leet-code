package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different
 * word or phrase, typically using all the original letters exactly once.
 *
 * Constraints:
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 */
public class ValidAnagram {

    private static final int NUMBER_OF_ENGLISH_LETTERS = 26;

    /**
     * Runtime: 4 ms, faster than 84.53% of Java online submissions for Valid Anagram.
     * Memory Usage: 45.2 MB, less than 31.50% of Java online submissions for Valid Anagram.
     */
    public static boolean isAnagramSort(String s, String t) {
        char[] sCharArr = s.toCharArray();
        char[] tCharArr = t.toCharArray();
        Arrays.sort(sCharArr);
        Arrays.sort(tCharArr);
        return new String(sCharArr).equals(new String(tCharArr));
    }

    /**
     * Runtime: 10 ms, faster than 36.21% of Java online submissions for Valid Anagram.
     * Memory Usage: 43.4 MB, less than 76.14% of Java online submissions for Valid Anagram.
     */
    public static boolean isAnagramArray(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] charCountArr = new int[NUMBER_OF_ENGLISH_LETTERS];
        for (int i = 0; i < s.length(); i++) {
            charCountArr[s.codePointAt(i) % NUMBER_OF_ENGLISH_LETTERS]++;
            charCountArr[t.codePointAt(i) % NUMBER_OF_ENGLISH_LETTERS]--;
        }

        for (int i = 0; i < charCountArr.length; i++) {
            if (charCountArr[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isAnagramHashMap(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> charToCountMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            charToCountMap.compute(c, (key, value) -> (value == null) ? 1 : ++value);
        }
        for (char c : t.toCharArray()) {
            if (charToCountMap.containsKey(c)) {
                charToCountMap.put(c, charToCountMap.get(c) - 1);
            } else {
                charToCountMap.put(c, -1);
            }
        }
        for (int count : charToCountMap.values()) {
            if (count != 0) return false;
        }

        return true;
    }

}
