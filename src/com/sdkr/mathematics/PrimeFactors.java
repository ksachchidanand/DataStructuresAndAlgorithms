public class PrimeFactors {
    public static void main(String[] args) {
        var reader = new FastIO();
        int n = reader.nextInt();
        // primeFactorsNaive(n);
        // primeFactor(n);
        primeFactorOptimized(n);
    }

    public static void primeFactorsNaive(int n) {
        for (int i=2; i<n; i++) {
            if (IsPrime.isPrime(i)) {
                int x = i;
                while (n % x == 0) {
                    System.out.println(i);
                    x *= i;
                }
            }
        }
    }

    public static void primeFactor(int n) {
        if (n <= 1) return;

        for (int i=2; i*i<=n; ++i) {
            while (n%i==0) {
                System.out.println(i);
                n /= i;
            }
        }

        if (n > 1)
            System.out.println(n);
    }

    public static void primeFactorOptimized(int n) {
        if (n <= 1) return;

        while (n % 2 == 0) {
            System.out.println(2);
            n /= 2;
        }

        while (n % 3 == 0) {
            System.out.println(3);
            n /= 3;
        }

        for (int i=5; i*i<=n; i+=6) {
            while(n%i==0) {
                System.out.println(i);
                n /= i;
            }

            while(n%(i+2)==0) {
                System.out.println(i+2);
                n /= (i+2);
            }
        }

        if (n > 3)
            System.out.println(n);
    }
}