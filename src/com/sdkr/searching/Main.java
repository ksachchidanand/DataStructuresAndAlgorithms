package com.sdkr.searching;

public class Main {

    public static void main(String[] args) {
        int index = new LastOccurrence(new int[] {1, 3, 3, 3, 4, 6, 6}).recursive(3);
        System.out.println(index);
    }
}
