package medium;

import java.util.*;

public class GenerateParentheses {

    private static final char LEFT_PARENTHESIS = '(';
    private static final char RIGHT_PARENTHESIS = ')';

    /**
     * Runtime 1 ms Beats 95.67%
     * Memory 43.6 MB Beats 42.30%
     */
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backTrack(result, "", 0, 0, n);
        return result;
    }

    private static void backTrack(List<String> result, String str, int open, int close, int max) {
        if (str.length() == max * 2) {
            result.add(str);
        }

        if (open < max) {
            backTrack(result, str+"(", open+1, close, max);
        }
        if (close < open) {
            backTrack(result, str+")", open, close + 1, max);
        }
    }

    protected static boolean validString(String str) {
        Deque<Character> deque = new LinkedList<>();
        for (char ch : str.toCharArray()) {
            if (ch == LEFT_PARENTHESIS) {
                deque.push(ch);
            } else {
                if (deque.isEmpty()) {
                    return false;
                } else {
                    if (deque.pop() != LEFT_PARENTHESIS) return false;
                }
            }
        }
        return deque.isEmpty();
    }

}
