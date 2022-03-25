package com.aads.fibonacci;

public class FibonacciNumbers {

    public static void main(String[] args) {
        System.out.println(fibEffective(100));
    }

    //native (not effective)
    private static long fibNative(int n) {
        if (n <= 1)
            return n;

        return fibNative(n - 1) + fibNative(n - 2);
    }

    //effective
    private static long fibEffective(int n) {
        long[] arr = new long[n + 1];

        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }
}
