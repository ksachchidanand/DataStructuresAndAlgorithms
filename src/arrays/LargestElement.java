package arrays;

public class LargestElement {
    public int getLargest(int[] items) {
        int max = Integer.MIN_VALUE;
        for (var item : items) {
            if (item > max)
                max = item;
        }

        return max;
    }
}
