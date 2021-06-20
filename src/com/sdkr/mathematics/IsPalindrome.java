public class IsPalindrome {
    public static void main(String[] args) {
        var sc = new FastIO();
        int n = sc.nextInt();

        System.out.println(isPalidrome(n));
    }

    public static boolean isPalidrome(int n) {
        int rev = 0;
        int num = n;
        while (n > 0) {
            rev = (10 * rev) + (n % 10);
            n /= 10;
        }

        return rev == num;
    }
}
