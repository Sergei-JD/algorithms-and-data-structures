package com.aads.sort.coctailSort;

import java.util.Arrays;

public class CocktailSort {

    public static void main(String[] args) {

        int[] array = new int[] { 5, 0, -2, 7, 3 };

        cocktailSort(array);

        System.out.println(Arrays.toString(array));

    }

    public static void cocktailSort(int[] sequence) {
        int left = 0;
        int right = sequence.length - 1;
        int control = right;
        while (left < right) {
            for (int i = left; i < right; i++) {
                if (sequence[i] > sequence[i + 1]) {
                    swap(sequence, i, i + 1);
                    control = i;
                }
            }
            right = control;
            for (int i = right; i > left; i--) {
                if (sequence[i] < sequence[i - 1]) {
                    swap(sequence, i, i - 1);
                    control = i;
                }
            }
            left = control;
        }
    }

    public static void swap(int[] sequence, int i, int j) {
        int temp = sequence[i];
        sequence[i] = sequence[j];
        sequence[j] = temp;
    }
}
