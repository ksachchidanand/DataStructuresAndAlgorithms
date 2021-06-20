import java.util.Arrays;

public class MinimumCoinChange {
    private final static int[] coins = { 1, 7, 10 };

    public static void main(String[] args) {
        var reader = new FastReader();
        int amount = reader.nextInt();
        System.out.println(minimumCoinChangeRecursive(amount));
        System.out.println(minimumCoinChangeTopDown(amount));
        System.out.println(minimunCoinChangeBottomUp(amount));
    }

    private static int minimumCoinChangeRecursive(int amount) {
        if (amount == 0)
            return 0;

        int minStep = Integer.MAX_VALUE;
        for (var coin : coins) {
            if ((amount - coin) >= 0) {
                minStep = Math.min(minStep, minimumCoinChangeRecursive(amount - coin));
            }
        }

        return minStep + 1;
    }

    private static int minimumCoinChangeTopDown(int amount) {
        int[] dp = new int[amount + 3];
        Arrays.fill(dp, -1);
        return minimunCoinChangeTopDown(amount, dp);
    }

    private static int minimunCoinChangeTopDown(int amount, int[] dp) {
        if (amount == 0)
            return 0;

        if (dp[amount] != -1)
            return dp[amount];

        int minStep = Integer.MAX_VALUE;
        for (var coin : coins) {
            if (amount - coin >= 0) {
                minStep = Math.min(minStep, minimunCoinChangeTopDown(amount - coin, dp));
            }
        }

        return dp[amount] = minStep + 1;
    }

    private static int minimunCoinChangeBottomUp(int amount) {
        if (amount == 0)
            return amount;

        int[] dp = new int[amount + 3];

        for (int i = 1; i <= amount; i++) {
            int minStep = Integer.MAX_VALUE;
            for (var coin : coins) {
                if (i - coin >= 0) {
                    minStep = Math.min(minStep, dp[i - coin]);
                    dp[i] = minStep + 1;
                }
            }
        }

        return dp[amount];
    }
}
