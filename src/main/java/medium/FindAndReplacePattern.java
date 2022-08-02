package medium;

import java.util.*;

/**
 * Given a list of strings words and a string pattern, return a list of words[i] that match pattern. You may return
 * the answer in any order.
 *
 * A word matches the pattern if there exists a permutation of letters p so that
 * after replacing every letter x in the pattern with p(x), we get the
 * desired word.
 *
 * Recall that a permutation of letters is a bijection from letters to
 * letters: every letter maps to another letter, and no two letters map
 * to the same letter.
 *
 * Constraints:
 * 1 <= pattern.length <= 20
 * 1 <= words.length <= 50
 * words[i].length == pattern.length
 * pattern and words[i] are lowercase English letters.
 */
public class FindAndReplacePattern {

    private static final short NUMBER_OF_ENGLISH_LETTERS = 26;

    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new LinkedList<>();

        for (String word : words) {
            if (bijectiveMappingExistsSingleArrray(word, pattern)) {
                result.add(word);
            }
        }

        return result;
    }

    /**
     * Runtime: 4 ms, faster than 26.36% of Java online submissions for Find and Replace Pattern.
     * Memory Usage: 43.6 MB, less than 21.12% of Java online submissions for Find and Replace Pattern.
     */
    public static boolean bijectiveMappingExists(String word, String pattern) {
        Map<Character, Character> patternToWord = new HashMap<>();
        Map<Character, Character> wordToPattern = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char patternChar = pattern.charAt(i);
            char wordChar = word.charAt(i);

            if (patternToWord.containsKey(patternChar)) {
                if (patternToWord.get(patternChar) != (wordChar)) {
                    return false;
                }
            } else if (wordToPattern.containsKey(wordChar)) {
                if (wordToPattern.get(wordChar) != (patternChar)) {
                    return false;
                }
            } else {
                patternToWord.put(patternChar, wordChar);
                wordToPattern.put(wordChar, patternChar);
            }

        }
        return true;
    }

    /**
     * Runtime: 1 ms, faster than 93.97% of Java online submissions for Find and Replace Pattern.
     * Memory Usage: 43.2 MB, less than 43.47% of Java online submissions for Find and Replace Pattern.
     */
    public static boolean bijectiveMappingExistsSingleArrray(String word, String pattern) {
        char[] mappingArr = new char[NUMBER_OF_ENGLISH_LETTERS * 2];
        for (int i = 0; i < word.length(); i++) {
            char patternChar = pattern.charAt(i);
            char wordChar = word.charAt(i);

            // pattern to word already exists
            char patternToWordMappedChar = mappingArr[patternChar % NUMBER_OF_ENGLISH_LETTERS];
            char wordToPatternMappedChar = mappingArr[(wordChar % NUMBER_OF_ENGLISH_LETTERS) + NUMBER_OF_ENGLISH_LETTERS];
            if (patternToWordMappedChar != '\u0000' && patternToWordMappedChar != wordChar) {
                    return false;
            }
            // word to pattern already exists
            else if (wordToPatternMappedChar != '\u0000' && wordToPatternMappedChar != patternChar) {
                    return false;
            } else {
                mappingArr[patternChar % NUMBER_OF_ENGLISH_LETTERS] = wordChar;
                mappingArr[(wordChar % NUMBER_OF_ENGLISH_LETTERS) + NUMBER_OF_ENGLISH_LETTERS] = patternChar;
            }
        }
        return true;
    }

    public static String buildCharactersCountingString(String word) {
        if (word.length() == 1) {
            return "1";
        }

        word = word + "!";
        Set<Character> charCache = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        short numberOfChars = 1;
        for (int i = 0; i < word.length() - 1; i++) {
            char currentChar = word.charAt(i);
            char nextChar = word.charAt(i + 1);
            if (currentChar == nextChar) {
                numberOfChars++;
            }
            if (currentChar != nextChar || i + 1 == word.length() - 1) {
                sb.append(numberOfChars);
                if (charCache.contains(currentChar)) {
                    sb.append("+");
                }
                numberOfChars = 1;
                charCache.add(currentChar);
            }
        }
        return sb.toString();
    }

}
