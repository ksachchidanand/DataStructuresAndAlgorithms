import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaximumSumKPartition {
    private final static FastReader reader = new FastReader();

    public static void main(String[] args) {
        long n = reader.nextLong();
        long k = reader.nextLong();
        long[] a = new long[(int) n];
        for (int i = 0; i < n; i++) {
            a[i] = reader.nextLong();
        }

        System.out.println();
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

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
