public class NumberOfWaysToReachTop {
    public static void main(String[] args) {
        var reader = new FastReader();
        int n = reader.nextInt();
        int k = reader.nextInt();
        System.out.println(countNumberOfWaysToReachTopRecursive(n, k));
        System.out.println(countNumberOfWaysToReachTopTopDown(n, k));
        System.out.println(countNumberOfWaysToReachTopBottomUp(n, k));
    }

    public static int countNumberOfWaysToReachTopRecursive(int n, int k) {
        if (n == 0)
            return 1;

        int result = 0;
        for (int i = 1; i <= k; i++) {
            if (n - i >= 0)
                result += countNumberOfWaysToReachTopRecursive(n - i, k);
        }

        return result;
    }

    public static int countNumberOfWaysToReachTopTopDown(int n, int k) {
        int[] dp = new int[n + 1];
        return countNumberOfWaysToReachTopTopDown(n, k, dp);
    }

    public static int countNumberOfWaysToReachTopTopDown(int n, int k, int[] dp) {
        if (n == 0)
            return 1;

        if (dp[n] != 0)
            return dp[n];

        int result = 0;
        for (int i = 1; i <= k; i++) {
            if (n - i >= 0)
                result += countNumberOfWaysToReachTopTopDown(n - i, k, dp);
        }

        return dp[n] = result;
    }

    public static int countNumberOfWaysToReachTopBottomUp(int n, int k) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0)
                    dp[i] += dp[i - j];
            }
        }

        return dp[n];
    }
}
