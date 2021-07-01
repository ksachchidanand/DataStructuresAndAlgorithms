package dynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public int recursive(String s1, String s2) {
        int len1 = s1.length() - 1;
        int len2 = s2.length() - 1;

        return recursive(s1, s2, len1, len2);
    }

    private int recursive(String s1, String s2, int len1, int len2) {
        if (len1 < 0 || len2 < 0)
            return 0;

        if (s1.charAt(len1) == s2.charAt(len2))
            return recursive(s1, s2, len1 - 1, len2 - 1) + 1;

        return Math.max(recursive(s1, s2, len1 - 1, len2), recursive(s1, s2, len1, len2 - 1));
    }

    public int topDown(String s1, String s2) {
        int len1 = s1.length() - 1;
        int len2 = s2.length() - 1;

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (var a : dp)
            Arrays.fill(a, -1);

        return topDown(s1, s2, len1, len2, dp);
    }

    private int topDown(String s1, String s2, int len1, int len2, int[][] dp) {
        if (len1 < 0 || len2 < 0)
            return 0;

        if (dp[len1][len2] != -1)
            return dp[len1][len2];

        if (s1.charAt(len1) == s2.charAt(len2))
            return dp[len1][len2] = 1 + topDown(s1, s2, len1 - 1, len2 - 1, dp);

        return dp[len1][len2] = Math.max(topDown(s1, s2, len1 - 1, len2, dp), topDown(s1, s2, len1, len2 - 1, dp));
    }

    public int bottomUp(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; i++)
            for (int j = 1; j <= len2; j++)
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

        return dp[len1][len2];
    }
}
