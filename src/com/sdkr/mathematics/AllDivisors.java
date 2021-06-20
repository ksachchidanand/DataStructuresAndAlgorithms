public class AllDivisors {
    public static void main(String[] args) {
        var reader = new FastIO();
        int n = reader.nextInt();
        allDivisors(n);
    }

    public static void allDivisorsNaive(int n) {
        for (int i=1; i<=n; i++) {
            if (n % i == 0)
                System.out.println(i);
        }
    }

    public static void allDivisors(int n) {
        int i = 1;
        for (; i*i<=n; i++) {
            if (n % i == 0)
                System.out.println(i);
        }

        for (; i>=1; i--) {
            if (n % i == 0)
                System.out.println(n / i);
        }
    }
}
