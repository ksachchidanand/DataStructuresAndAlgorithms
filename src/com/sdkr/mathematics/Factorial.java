public class Factorial {
    public static void main(String[] args) {
        var reader = new FastIO();
        long n = reader.nextInt();

        System.out.println(factorial(n));
        System.out.println(factorialRecursive(n));
    }

    public static long factorial(long n) {
        long fac = 1;
        for (long i=1; i<=n; i++) {
            fac *= i;
        }

        return fac;
    }

    public static long factorialRecursive(long n) {
        if (n == 0)
            return 1;

        return n * factorialRecursive(n - 1);
    }
}
