package easy;

public class ClimbingStairs {

    /**
     * Time Limit Exceeded
     */
    public static int climbStairs(int n) {
        return generatePossibilities(1, 0, n) + generatePossibilities(2, 0, n);
    }

    private static int generatePossibilities(int step, int sum, int max) {
        if (step + sum == max) {
            return 1;
        } else if (step + sum > max) {
            return 0;
        } else {
            sum += step;
            return generatePossibilities(1, sum, max) + generatePossibilities(2, sum, max);
        }
    }

    /**
     * Runtime 0 ms Beats 100%
     * Memory 39.3 MB Beats 67.52%
     */
    public static int climbStairsSolutionFromLeetCode(int n) {
        if (n <= 2) {
            return n;
        }
        int[] a = new int[n];
        a[0] = 1;
        a[1] = 2;

        for (int i = 2; i < n; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[n - 1];
    }

    /**
     * Runtime 0 ms Beats 100%
     * Memory 39.1 MB Beats 87.26%
     */
    public static int climbStairsSolutionFromLeetCodeWithLessMemory(int n) {
        if (n <= 2) {
            return n;
        }

        int x = 1, y = 2;

        for (int i = 2; i < n; i++) {
            int temp = x; x = y; y = temp + y;
        }
        return y;
    }
}
