public class TrailingZeroInFactorial {
    public static void main(String[] args) {
        var reader = new FastIO();
        int n = reader.nextInt();

        System.out.println(countZero(n));
    }

    public static int countZero(int n) {
        int count = 0;
        for (int i=5; i<=n; i*=5) {
            count += n / i;
        }

        return count;
    }
}
