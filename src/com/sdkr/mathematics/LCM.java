public class LCM {
    public static void main(String[] args) {
        var reader = new FastIO();

        int m = reader.nextInt();
        int n = reader.nextInt();

        // a * b = gcd(a, b) * lcm(a, b);

        System.out.println(lcm(m, n));
    }

    private static int gcd(int m, int n) {
        if (n == 0)
            return m;
        else 
            return gcd(n, m%n);
    }

    public static int lcm(int m, int n) {
        return (m * n) / gcd(m , n);
    }
}
