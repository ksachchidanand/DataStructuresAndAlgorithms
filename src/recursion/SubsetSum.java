package recursion;

public class SubsetSum {
    public int recursive(int[] arr, int sum) {
        return recursive(arr, 0, 0, sum);
    }

    private int recursive(int[] arr, int index, int currentSum, int sum) {
        if (index == arr.length) {
            if (currentSum == sum)
                return 1;
            else
                return 0;
        }

        int count = 0;
        count += recursive(arr, index + 1, currentSum, sum);
        count += recursive(arr, index + 1, currentSum + arr[index], sum);

        return count;
    }
}
