import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FastReader {
    private final BufferedReader bufferedReader;
    private StringTokenizer stringTokenizer;

    public FastReader() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String next() {
        try {
            while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            }
        } catch (IOException exception) {
            exception.getMessage();
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
