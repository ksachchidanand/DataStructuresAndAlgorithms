public class MinimumStepsToOne {
    public static void main(String[] args) {
        var reader = new FastReader();
        int n = reader.nextInt();

        System.out.println(minimumStepsToOneRecursive(n));
        System.out.println(minimumStepsToOneTopDown(n));
        System.out.println(minimumStepsToOneBottomUp(n));
    }

    private static int minimumStepsToOneRecursive(int n) {
        if (n == 1)
            return 0;

        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        int z = Integer.MAX_VALUE;

        if (n % 3 == 0)
            x = minimumStepsToOneRecursive(n / 3);
        if (n % 2 == 0)
            y = minimumStepsToOneRecursive(n / 2);
        z = minimumStepsToOneRecursive(n - 1);

        return Math.min(x, Math.min(y, z)) + 1;
    }

    private static int minimumStepsToOneTopDown(int n) {
        int[] dp = new int[n + 3];
        return minimumStepsToOneTopDown(n, dp);
    }

    private static int minimumStepsToOneTopDown(int n, int[] dp) {
        if (n == 1)
            return 0;
        if (dp[n] != 0)
            return dp[n];

        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        int z = Integer.MAX_VALUE;

        if (n % 3 == 0)
            x = minimumStepsToOneRecursive(n / 3);
        if (n % 2 == 0)
            y = minimumStepsToOneRecursive(n / 2);
        z = minimumStepsToOneRecursive(n - 1);

        return dp[n] = Math.min(x, Math.min(y, z)) + 1;
    }

    private static int minimumStepsToOneBottomUp(int n) {
        int[] dp = new int[1000];
        for (int i = 2; i <= n; i++) {
            int x = Integer.MAX_VALUE;
            int y = Integer.MAX_VALUE;
            int z = Integer.MAX_VALUE;

            if (i % 3 == 0)
                x = dp[i / 3] + 1;
            if (i % 2 == 0)
                y = dp[i / 2] + 1;
            z = dp[i - 1] + 1;

            dp[i] = Math.min(x, Math.min(y, z));
        }

        return dp[n];
    }
}