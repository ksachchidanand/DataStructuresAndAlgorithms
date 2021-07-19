package recursion;

public class JosephusCircle {
    public int recursive(int n, int k) {
        boolean[] deaths = new boolean[n];

        return recursive(n, k, deaths);
    }

    private int recursive(int n, int k, boolean[] deaths) {
        if (n == 1)
            return 0;
        return (recursive(n - 1, k) + k) % n;
    }
}
