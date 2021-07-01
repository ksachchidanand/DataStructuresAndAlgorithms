package dynamicProgramming;

public class Fibonacci {

    public int recursive(int n) {
        if (n == 1 || n == 0)
            return n;
        return recursive(n - 1) + recursive(n - 2);
    }

    public int topDown(int n) {
        int[] dp = new int[n + 1];
        return topDown(n, dp);
    }

    private int topDown(int n, int[] arr) {
        if (n == 1 || n == 0)
            return n;
        if (arr[n] != 0)
            return arr[n];
        return arr[n] = topDown(n - 1, arr) + topDown(n - 2, arr);
    }

    public int bottomUp(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 0;
        if (n == 0)
            return dp[0];

        dp[1] = 1;
        if (n == 1)
            return dp[1];

        for (int i = 2; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];

        return dp[n];
    }

    public int bottomUpSpaceOptimizer(int n) {
        int a = 0;
        int b = 1;
        int sum = 0;
        if (n == 0)
            return a;
        if (n == 1)
            return b;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }

        return sum;
    }

    // A better approch is available to find the nth
    // fibonacci number which find nth fibonacci in O(log n)
    // dp is not the best solution for fibonacci number
}
