package com.aads.search.fibonacciSearch;

public class FibonacciSearch {

    private int i;
    private int p;
    private int q;
    private boolean stop = false;

    public FibonacciSearch() {
    }

    private void init(int[] sequence) {
        stop = false;
        int k = 0;
        int n = sequence.length;
        for (; getFibonacciNumber(k + 1) < n + 1;) {
            k += 1;
        }
        int m = (int) (getFibonacciNumber(k + 1) - (n + 1));
        i = (int) (getFibonacciNumber(k) - m);
        p = (int) getFibonacciNumber(k - 1);
        q = (int) getFibonacciNumber(k - 2);
    }

    public long getFibonacciNumber(int k) {
        long firstNumber = 0;
        long secondNumber = 1;
        for (int i = 0; i < k; i++) {
            long temp = secondNumber;
            secondNumber += firstNumber;
            firstNumber = temp;
        }
        return firstNumber;
    }

    private void upIndex() {
        if (p == 1)
            stop = true;
        i = i + q;
        p = p - q;
        q = q - p;
    }

    private void downIndex() {
        if (q == 0)
            stop = true;
        i = i - q;
        int temp = q;
        q = p - q;
        p = temp;
    }

    public int search(int[] sequence, int element) {
        init(sequence);
        int n = sequence.length;
        int resultIndex = -1;
        for (; !stop;) {
            if (i < 0) {
                upIndex();
            } else if (i >= n) {
                downIndex();
            } else if (sequence[i] == element) {
                resultIndex = i;
                break;
            } else if (element < sequence[i]) {
                downIndex();
            } else if (element > sequence[i]) {
                upIndex();
            }
        }
        return resultIndex;
    }
}
