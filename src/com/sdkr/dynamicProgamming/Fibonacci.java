public class Fibonacci {
    public static void main(String[] args) {
        var reader = new FastReader();
        int n = reader.nextInt();
        System.out.println(recursive(n));
        System.out.println(topDownDP(n));
        System.out.println(bottomUpDP(n));
        System.out.println(bottomUpDPOptimized(n));
    }

    public static int recursive(int n) {
        if (n == 0 || n == 1)
            return n;
        return recursive(n - 1) + recursive(n - 2);
    }

    public static int topDownDP(int n) {
        int[] dpArray = new int[n + 1];
        return topDownDP(n, dpArray);
    }

    private static int topDownDP(int n, int[] dpArray) {
        if (n == 0 || n == 1)
            return dpArray[n] = n;

        if (dpArray[n] != 0)
            return dpArray[n];
        
        return dpArray[n] = topDownDP(n - 1, dpArray) + topDownDP(n - 2, dpArray);
    }

    public static int bottomUpDP(int n) {
        int[] dpArray = new int[n+1];
        dpArray[0] = 0;
        dpArray[1] = 1;
        for (int i=2; i<=n; ++i) {
            dpArray[i] = dpArray[i-1] + dpArray[i-2];
        }

        return dpArray[n];
    }

    public static int bottomUpDPOptimized(int n) {
        int a = 0;
        int b = 1;
        while (--n != 0) {
            int sum = a + b;
            a = b;
            b = sum;
        }

        return b;
    }
}