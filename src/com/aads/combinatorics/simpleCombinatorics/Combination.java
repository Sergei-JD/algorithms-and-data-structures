package com.aads.combinatorics.simpleCombinatorics;

public class Combination {

    public static void main(String[] args) {

        printAllCombination(5, 3);
    }

    private static void printAllCombination(int n, int k) {
        int[] comb = new int[k + 2];
        for (int i = 0; i < k; i++) {
            comb[i] = i;
        }
        comb[k] = n;
        comb[k + 1] = 0;
        for (;;) {
            printArray(comb, 0, k);
            int j = 0;
            for (; comb[j] + 1 == comb[j + 1];) {
                comb[j] = j;
                j = j + 1;
            }
            if (j < k) {
                comb[j]++;
            } else {
                break;
            }
        }
    }

    private static void printArray(int[] array, int s, int e) {
        System.out.print("[");
        for (int i = s; i < e - 1; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println(array[e - 1] + "]");
    }

}
