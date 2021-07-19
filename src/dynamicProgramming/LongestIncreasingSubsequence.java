package dynamicProgramming;

public class LongestIncreasingSubsequence {
    public int recusive(int[] arr) {
        return recusive(arr, arr.length, Integer.MAX_VALUE);
    }

    private int recusive(int[] arr, int len, int max) {
        if (len == 0)
            return 0;

        int a = recusive(arr, len - 1, max);
        int b = 0;
        if (max >= arr[len - 1])
            b = recusive(arr, len - 1, arr[len - 1]) + 1;
        return Math.max(a, b);
    }

    public int bottomUp(int[] arr) {
        int[] lis = new int[arr.length];

        lis[0] = 1;

        for (int i = 1; i < arr.length; ++i) {
            lis[i] = 1;
            for (int j = 0; j < i; ++j)
                if (arr[j] < arr[i])
                    lis[i] = Math.max(lis[i], lis[j] + 1);
        }

        int res = lis[0];
        for (int i = 1; i < arr.length; ++i) {
            res = Math.max(res, lis[i]);
        }

        return res;
    }

    // [8, 100, 150, 10, 12, 14, 110]
    // O/P: 5
    // public int binarySearch() {

    // }
}
