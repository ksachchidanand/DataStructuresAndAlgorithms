package dynamicProgramming;

import java.util.Arrays;

public class CoinChange {
    public int recursive(int[] coins, int sum) {
        int len = coins.length;

        return recursive(coins, sum, len);
    }

    private int recursive(int[] coins, int sum, int len) {
        if (len == 0 || sum < 0)
            return 0;

        if (sum == 0)
            return 1;

        return recursive(coins, sum, len - 1) + recursive(coins, sum - coins[len - 1], len);
    }

    public int topDown(int[] coins, int sum) {
        int len = coins.length;

        int[][] dp = new int[sum + 1][len + 1];

        for (int i = 0; i <= sum; i++)
            Arrays.fill(dp[i], -1);

        return topDown(coins, sum, len, dp);
    }

    private int topDown(int[] coins, int sum, int len, int[][] dp) {
        if (len == 0 || sum < 0)
            return 0;

        if (sum == 0)
            return 1;

        if (dp[sum][len] != -1)
            return dp[sum][len];

        return dp[sum][len] = topDown(coins, sum, len - 1, dp) + topDown(coins, sum - coins[len - 1], len, dp);
    }

    public int bottomUp(int[] coins, int sum) {
        int len = coins.length;

        int dp[][] = new int[sum + 1][len + 1];

        for (int i = 0; i <= len; ++i) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= sum; ++i) {
            for (int j = 1; j <= len; ++j) {
                dp[i][j] = dp[i][j - 1];
                if (coins[j - 1] <= i)
                    dp[i][j] += dp[i - coins[j - 1]][j];
            }
        }

        return dp[sum][len];
    }
}