import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private final static FastReader reader = new FastReader();

    public static void main(String[] args) {
        int amount = reader.nextInt();
        int arraySize = reader.nextInt();
        int[] coins = new int[arraySize];
        for (int i = 0; i < arraySize; ++i) {
            coins[i] = reader.nextInt();
        }

        System.out.println(countChange(amount, coins));
    }

    public static int countChange(int amount, int[] coins) {
        int[] dp = new int[amount + 3];
        for (int i = 1; i <= amount; ++i) {
            int minStep = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0) {
                    minStep = Math.min(minStep, dp[i - coin]);
                    dp[i] = minStep + 1;
                }
            }
        }

        return dp[amount];
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
