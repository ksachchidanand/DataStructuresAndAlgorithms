public class WineProblem {
    private static final int[] pricesOfWine = { 2, 4, 6, 2, 5 };

    public static void main(String[] args) {
        System.out.println(maximumProfitRecursive(0, pricesOfWine.length - 1, 1));
        System.out.println(maximumProfitTopDown(0, pricesOfWine.length - 1, 1));
    }

    private static int maximumProfitRecursive(int i, int j, int y) {
        if (i > j)
            return 0;

        int left = pricesOfWine[i] * y + maximumProfitRecursive(i + 1, j, y + 1);
        int right = pricesOfWine[j] * y + maximumProfitRecursive(i, j - 1, y + 1);

        return Math.max(left, right);
    }

    private static int maximumProfitTopDown(int i, int j, int y) {
        int[][] dp = new int[pricesOfWine.length + 1][pricesOfWine.length + 1];
        return maximumProfitTopDown(i, j, y, dp);
    }

    private static int maximumProfitTopDown(int i, int j, int y, int[][] dp) {
        if (i > j)
            return 0;

        if (dp[i][j] != 0)
            return dp[i][j];

        int left = pricesOfWine[i] * y + maximumProfitTopDown(i + 1, j, y + 1, dp);
        int right = pricesOfWine[j] * y + maximumProfitTopDown(i, j - 1, y + 1, dp);

        return dp[i][j] = Math.max(left, right);
    }

    // private static int maximumProfitBottomUp(int i, int j, int y) {
    // int[][] dp = new int[pricesOfWine.length + 1][pricesOfWine.length + 1];

    // for (int i=)
    // }
}
