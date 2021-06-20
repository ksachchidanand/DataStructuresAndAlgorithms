import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CountNumberOfBinaryString {
    private final static FastReader reader = new FastReader();

    public static void main(String[] args) {
        int tt = reader.nextInt();
        while (tt-- != 0) {
            int n = reader.nextInt();
            System.out.println(countNumberOfBinaryString(n));
        }
    }

    private static long countNumberOfBinaryString(long n) {
        long a = 1;
        long b = 1;
        long sum = 0;
        while (n-- != 0) {
            sum = a + b;
            a = b;
            b = sum;
        }

        return sum;
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
