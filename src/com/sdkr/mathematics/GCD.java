public class GCD {
    public static void main(String[] args) {
        var reader = new FastIO();
        int m = reader.nextInt();
        int n = reader.nextInt();

        System.out.println(gcd(m, n));
        System.out.println(gcdRecursive(m, n));
        System.out.println(gcdOptimized(m, n));
    }

    public static int gcd(int m, int n) {
        while (m != n) {
            if (m > n)
                m = m - n;
            else 
                n = n - m;
        }

        return m;
    }

    public static int gcdRecursive(int m, int n) {
        if (m == n)
            return n;
        if (n > m)
            return gcd(m, n - m);
        else
            return gcd(m - n, n);
    }

    public static int gcdOptimized(int m, int n) {
        if (n == 0)
            return 0;
        else
            return gcd(n, m%n);
    }
}
