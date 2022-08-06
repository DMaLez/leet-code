package easy;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Constraints:
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters.
 */
public class LongestCommonPrefix {

    /**
     * Runtime: 1 ms, faster than 89.34% of Java online submissions for Longest Common Prefix.
     * Memory Usage: 42.1 MB, less than 51.70% of Java online submissions for Longest Common Prefix.
     */
    public static String longestCommonPrefixSubstring(String[] strs) {
        if (strs.length == 0) return "";
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++)
            while(strs[i].indexOf(pre) != 0)
                pre = pre.substring(0,pre.length()-1);
        return pre;
    }

    public static String longestCommonPrefixXor(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }

        int shortestStringLength = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < shortestStringLength) {
                shortestStringLength = strs[i].length();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shortestStringLength; i++) {
            char firstChar = strs[0].charAt(i);
            char result = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                result ^= strs[j].charAt(i);
            }
            if (result != '\u0000' && result != firstChar) {
                return sb.toString();
            }
                sb.append(firstChar);
        }

        return sb.toString();
    }

    /**
     * Runtime: 1 ms, faster than 89.34% of Java online submissions for Longest Common Prefix.
     * Memory Usage: 41.8 MB, less than 76.05% of Java online submissions for Longest Common Prefix.
     */
    public static String longestCommonPrefixLoops(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }

        int shortestStringLength = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < shortestStringLength) {
                shortestStringLength = strs[i].length();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shortestStringLength; i++) {
            for (int j = 1; j < strs.length; j++) {
               if (strs[j - 1].charAt(i) != strs[j].charAt(i)) {
                   return sb.toString();
               }
            }
            sb.append(strs[0].charAt(i));
        }

        return sb.toString();
    }

}
