package test.dynamicProgamming;

import io.FastReader;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        var reader = new FastReader();
        var longestCommonSubsequence = new dynamicProgramming.LongestCommonSubsequence();
        var s1 = reader.next();
        var s2 = reader.next();
        System.out.println(longestCommonSubsequence.bottomUp(s1, s2));
        // longestCommonSubsequence.topDown(s1, s2);
    }
}
