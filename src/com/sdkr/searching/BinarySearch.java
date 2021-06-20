package com.sdkr.searching;

public class BinarySearch {
    public int iterative(int [] arr, int key) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (key < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    public int recursive(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;

        return recursive(arr, key, start, end);
    }

    private int recursive(int[] arr, int key, int start, int end) {
        if (start > end)
            return -1;

        int mid = start + (end - start) / 2;

        if (arr[mid] == key)
            return mid;
        else if (key < arr[mid])
            return recursive(arr, key, start, mid - 1);
        else
            return recursive(arr, key, mid + 1, end);
    }
}
