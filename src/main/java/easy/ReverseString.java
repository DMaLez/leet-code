package easy;

public class ReverseString {

    /**
     * Runtime 1 ms Beats 85.48%
     * Memory 50.8 MB Beats 53.27%
     */
    public static void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++; j--;
        }
    }

}
