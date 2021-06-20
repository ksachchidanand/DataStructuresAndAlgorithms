public class LongestCommonSubsequence {
    public static void main(String[] args) {
        var reader = new FastReader();
        String s1 = reader.next();
        String s2 = reader.next();

        System.out.println(lcsMemoization(s1, s2));
        System.out.println(lcsRecursive(s1, s2));
        System.out.println(lcsTabulation(s1, s2));
    }

    public static int lcsRecursive(String s1, String s2) {
        return lcsRecursive(s1, s1.length(), s2, s2.length());
    }

    public static int lcsRecursive(String s1, int i, String s2, int j) {
        if (i == 0 || j == 0)
            return 0;

        if (s1.charAt(i - 1) == s2.charAt(j - 1))
            return 1 + lcsRecursive(s1, i - 1, s2, j - 1);
        else
            return Math.max(lcsRecursive(s1, i - 1, s2, j), lcsRecursive(s1, i, s2, j - 1));
    }

    public static int lcsMemoization(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        return lcsMemoization(s1, s1.length(), s2, s2.length(), dp);
    }

    public static int lcsMemoization(String s1, int i, String s2, int j, int[][] dp) {
        if (i == 0 || j == 0)
            return 0;

        if (dp[i - 1][j - 1] != 0)
            return dp[i - 1][j - 1];

        if (s1.charAt(i - 1) == s2.charAt(j - 1))
            return dp[i - 1][j - 1] = 1 + lcsMemoization(s1, i - 1, s2, j - 1, dp);
        else
            return dp[i - 1][j - 1] = Math.max(lcsMemoization(s1, i - 1, s2, j, dp),
                    lcsMemoization(s1, i, s2, j - 1, dp));
    }

    public static int lcsTabulation(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
