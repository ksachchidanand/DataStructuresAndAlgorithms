public class MaximumSumArraySum {
    public static void main(String[] args) {
        var reader = new FastReader();
        int size = reader.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = reader.nextInt();
        }

        System.out.println(maximumSubArraySumRecursive(array));
    }

    public static int maximumSubArraySumRecursive(int[] array) {
        return maximumSubArraySumRecursive(array, 0, array.length - 1);
    }

    public static int maximumSubArraySumRecursive(int[] array, int left, int right) {
        if (left > right)
            return 0;

        int currentSum = 0;

        int leftSum = currentSum - maximumSubArraySumRecursive(array, left + 1, right);
        int rightSum = currentSum - maximumSubArraySumRecursive(array, left, right - 1);

        return Math.max(currentSum, Math.max(leftSum, rightSum));
    }
}
