package easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine
 * if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 * Constraints:
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */
public class ValidParentheses {

    /**
     * Runtime: 2 ms, faster than 90.79% of Java online submissions for Valid Parentheses.
     * Memory Usage: 42.2 MB, less than 42.60% of Java online submissions for Valid Parentheses.
     */
    public static boolean isValidStackBased(String s) {
        Deque<Character> bracketsStack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '(' || current == '{' || current == '[') {
                bracketsStack.addLast(current);
            } else {
                Character ch = bracketsStack.pollLast();
                if (ch == null || current != getMatchingClosingBracket(ch))
                    return false;
            }
        }
        return bracketsStack.isEmpty();
    }
    private static char getMatchingClosingBracket(char openBracket) {
        switch (openBracket) {
            case '(': return ')';
            case '{': return '}';
            case '[': return ']';
            default: throw new IllegalArgumentException("Not an open bracket");
        }
    }
}
