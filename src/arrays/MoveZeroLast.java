package arrays;

import java.util.Arrays;

public class MoveZeroLast {
    public static void main(String[] args) {
        int[] nums = { 10, 20, 0, 0, 0 };

        solution(nums);

        System.out.println(Arrays.toString(nums));
    }

    private static void solution(int[] nums) {
        var length = nums.length;
        var replace = 0;
        var move = 0;

        while (move < length) {
            if (replace == move) {
                if (nums[move] != 0) {
                    replace++;
                    move++;
                } else {
                    move++;
                }
            } else {
                if (nums[move] != 0) {
                    nums[replace++] = nums[move];
                    nums[move] = 0;
                } else {
                    move++;
                }
            }
        }
    }
}
