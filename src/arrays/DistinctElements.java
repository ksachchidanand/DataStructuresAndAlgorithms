package arrays;

import java.util.Arrays;

public class DistinctElements {
    public static void main(String[] args) {
        int[] nums = { 10, 10, 20, 30, 40, 50, 60, 70, 70 };

        var size = solution(nums);

        System.out.println(Arrays.toString(nums));

        for (int i = 0; i < size; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int solution(int[] nums) {
        int length = nums.length;
        int replace = 0;
        int move = 1;

        while (move < length) {
            if (nums[replace] == nums[move])
                move++;
            else
                nums[++replace] = nums[move++];
        }

        return replace + 1;
    }
}
