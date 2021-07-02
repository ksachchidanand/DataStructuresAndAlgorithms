package test.dynamicProgamming;

import io.FastReader;

public class CoinChange {
    public static void main(String[] args) {
        final var reader = new FastReader();
        final var coinChange = new dynamicProgramming.CoinChange();
        int n = reader.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++)
            coins[i] = reader.nextInt();
        int sum = reader.nextInt();
        System.out.println(coinChange.bottomUp(coins, sum));
    }
}
