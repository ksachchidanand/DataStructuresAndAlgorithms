package com.sdkr.searching;

public class LastOccurrence {
    private final int[] arr;

    public LastOccurrence(int[] arr) {
        this.arr = arr;
    }

    public int iterative(int key) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (key < arr[mid]) {
                end = mid - 1;
            } else if (key > arr[mid]) {
                start = mid + 1;
            } else {
                if (mid == arr.length - 1 || arr[mid] != arr[mid + 1]) {
                    return mid;
                } else {
                    start = mid + 1;
                }
            }
        }

        return -1;
    }

    private int recursive(int start, int end, int key) {
        if (start > end)
            return -1;

        int mid = start + (end - start) / 2;

        if (key < arr[mid]) {
            return recursive(start, mid - 1, key);
        } else if (key > arr[mid]) {
            return recursive(mid + 1, end, key);
        } else {
            if (mid == arr.length - 1 || arr[mid] != arr[mid + 1])
                return mid;
            else
                return recursive(mid + 1, end, key);
        }
    }

    public int recursive(int key) {
        int start = 0;
        int end = arr.length - 1;

        return recursive(start, end, key);
    }
}
