import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class FastIO {
    private final BufferedReader bufferedReader;
    private StringTokenizer stringTokenizer;

    public FastIO() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String next() {
        try {
            while(stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        return stringTokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }
}
