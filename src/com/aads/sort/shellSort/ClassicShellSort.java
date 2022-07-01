package com.aads.sort.shellSort;

import java.util.Arrays;

public class ClassicShellSort {

    public static void main(String[] args) {

        int[] array = new int[] { 5, 0, -2, 7, 3 };
        System.out.println("Source: " + Arrays.toString(array));
        shellSort(array);
        System.out.println("Result: " + Arrays.toString(array));
    }

    public static void shellSort(int[] array) {
        int step = array.length / 2;
        while (step > 0) {
            for (int i = step; i < array.length; i++) {
                for (int j = i; j >= step && array[j] < array[j - step]; j -= step) {
                    int temp = array[j];
                    array[j] = array[j - step];
                    array[j - step] = temp;
                }
            }
            step = step / 2;
        }
    }
}
