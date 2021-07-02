package dynamicProgramming;

import java.util.Arrays;

public class EditDistance {
    public int recursive(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        return recursive(s1, s2, m, n);
    }

    public int recursive(String s1, String s2, int m, int n) {
        if (m == 0)
            return n;
        if (n == 0)
            return m;

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return recursive(s1, s2, m - 1, n - 1);
        }

        int a = recursive(s1, s2, m, n - 1);
        int b = recursive(s1, s2, m - 1, n);
        int c = recursive(s1, s2, m - 1, n - 1);

        return Math.min(a, Math.min(b, c)) + 1;
    }

    public int topDown(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (var a : dp)
            Arrays.fill(a, -1);

        return topDown(s1, s2, m, n, dp);
    }

    private int topDown(String s1, String s2, int m, int n, int[][] dp) {
        if (m == 0)
            return n;
        if (n == 0)
            return m;

        if (dp[m][n] != -1)
            return dp[m][n];

        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            return dp[m][n] = topDown(s1, s2, m - 1, n - 1, dp);

        int a = topDown(s1, s2, m, n - 1, dp);
        int b = topDown(s1, s2, m - 1, n, dp);
        int c = topDown(s1, s2, m - 1, n - 1, dp);

        return dp[m][n] = Math.min(a, Math.min(b, c)) + 1;
    }

    public int bottomUp(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= n; ++i) {
            dp[0][i] = i;
        }

        for (int i = 0; i <= m; ++i) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
                }
            }
        }

        return dp[m][n];
    }
}
