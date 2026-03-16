// https://leetcode.com/problems/climbing-stairs/description/
package leet.code.dynamicprograming;

public class ClimbingStairs {
    public static int climbStairs(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        int prev1 = 2;
        int prev2 = 1;
        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
    /*public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }*/
    /*public static int climbStairs(int n) {
        int n1 = 1;
        int n2 = 2;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        return recursion(n, n1, n2);

    }

    private static int recursion(int n, int n1, int n2) {
        if (n - 3 == 0)
            return n1 + n2;
        return recursion(n-1, n2, n1 + n2);
    }*/
}
