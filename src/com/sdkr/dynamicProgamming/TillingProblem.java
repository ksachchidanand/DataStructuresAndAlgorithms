import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class TillingProblem {

    private static final int modulo = 1000000007;
    private static final FastReader reader = new FastReader();

    public static void main(String[] args) {
        int tt = reader.nextInt();

        while (tt-- != 0) {
            int n = reader.nextInt();
            int m = reader.nextInt();
            int[] dp = new int[n + 1];
            System.out.println(countTile(n, m));
        }
    }

    private static int countTile(int n, int m, int[] dp) {
        if (n == 1)
            return 1;

        if (dp[n] != 0)
            return dp[n];

        int horizontally = 0;
        int vertically = 0;

        horizontally = countTile(n - 1, m, dp);
        if (n - m >= 0)
            vertically = countTile(n - m, m, dp);

        return dp[n] = (horizontally + vertically) % modulo;
    }

    private static int countTile(int n, int m) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i >= m)
                dp[i] = dp[i - 1] + dp[i - m];
            else
                dp[i] = dp[i - 1];
        }

        return dp[n];
    }

    private static class FastReader {
        private final BufferedReader br;
        private StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreElements()) {
                    st = new StringTokenizer(br.readLine());
                }
            } catch (IOException exception) {
                exception.getMessage();
            }

            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
