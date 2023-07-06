package easy;

import java.util.*;

public class FindTheDifference {

    private static final int NUMBER_OF_ENGLISH_LETTERS = 26;

    /**
     * Runtime 1 ms Beats 100%
     * Memory 40.9 MB Beats 62.40%
     */
    public static char findTheDifferenceXOR(String s, String t) {
        char c = 0;
        for (char cs : s.toCharArray()) c ^= cs;
        for (char ct : t.toCharArray()) c ^= ct;
        return c;
    }

    /**
     * Runtime 11 ms Beats 15.96%
     * Memory 41.3 MB Beats 17.47%
     */
    public static char findTheDifferenceMap(String s, String t) {
        if (s.length() == 0) {
            return t.charAt(0);
        }

        Map<Character, Integer> map = new HashMap<>(NUMBER_OF_ENGLISH_LETTERS);
        for (int i = 0; i < s.length(); i++) {
            map.compute(s.charAt(i), (k, v) -> v == null ? 1 : ++v);
            map.compute(t.charAt(i), (k, v) -> v == null ? -1 : --v);
        }
        map.compute(t.charAt(t.length() - 1), (k, v) -> v == null ? -1 : --v);

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) return entry.getKey();
        }
        return 'a';
    }

    /**
     * Runtime 2ms Beats 68.93%
     * Memory 40.7 MB Beats 94.45%
     */
    public static char findTheDifferenceArray(String s, String t) {
        if (s.length() == 0) {
            return t.charAt(0);
        }

        boolean[] chars = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            int sIndex = s.charAt(i) - 'a';
            chars[sIndex] = !chars[sIndex];
            int tIndex = t.charAt(i) - 'a';
            chars[tIndex] = !chars[tIndex];
        }
        chars[t.charAt(t.length() - 1) - 'a'] = !chars[t.charAt(t.length() - 1) - 'a'];

        for (int i = 0; i < chars.length; i++) {
            if (chars[i]) {
                return (char) (i + 97);
            }
        }
        return 'a';
    }

    /**
     * Runtime 3ms Beats 43.98%
     * Memory 41.1 MB Beats 29.52%
     */
    public static char findTheDifferenceSort(String s, String t) {
        if (s.length() == 0) {
            return t.charAt(0);
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] != tChars[i]) return tChars[i];
        }
        return tChars[tChars.length - 1];
    }

}
