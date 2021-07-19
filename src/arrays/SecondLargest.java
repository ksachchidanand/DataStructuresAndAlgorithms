package arrays;

public class SecondLargest {
    public int secondLargest(int[] nums) {
        int max = -1;
        int secondMax = -1;
        for (var num : nums) {
            if (num > max) {
                secondMax = max;
                max = num;
            }
        }

        return secondMax;
    }
}