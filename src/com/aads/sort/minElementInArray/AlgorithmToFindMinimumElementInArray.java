package com.aads.sort.minElementInArray;

public class AlgorithmToFindMinimumElementInArray {

    public static void main(String[] args) {

        //Initialize array
        int[] array = new int[] {64, 42, 73, 41, 31, 53, 16, 24, 57, 42, 74, 55, 36};

        printArray(array);

        //Initialize min with first element of array.
        int minValue = array[0];
        //Initialize min with first index of array.
        int minIndex = 0;

        //Loop through the array
        for (int i = 1; i < array.length; i++) {
            //Compare elements of array with min
            if (array[i] < minValue) {
                minValue = array[i];
                minIndex = i;
            }
        }

        System.out.println("min value: " + minValue);
        System.out.println("min index: " + minIndex);
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.println("]");
    }
}
