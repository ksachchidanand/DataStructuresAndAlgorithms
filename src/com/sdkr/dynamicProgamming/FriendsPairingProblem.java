import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FriendsPairingProblem {
    private final static FastReader reader = new FastReader();

    public static void main(String[] args) {
        int tt = reader.nextInt();
        while (tt-- != 0) {
            int n = reader.nextInt();
            System.out.println(countAllCombinations(n));
        }
    }

    public static long countAllCombinations(int n) {
        long[] dp = new long[n + 1];
        for (int i = 0; i <= n; i++)
            if (i <= 2)
                dp[i] = i;
            else
                dp[i] = dp[i - 1] + (n - 1) * dp[i - 2];

        return dp[n];
    }

    public static class FastReader {
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
