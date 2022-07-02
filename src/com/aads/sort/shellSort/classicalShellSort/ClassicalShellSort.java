package com.aads.sort.shellSort.classicalShellSort;

/**
 *              Алгоритм сортировки Шелла.
 *      Сложность по времени в наихудшем случае O(n2)
 *      Затраты памяти O(n)
 *
*               Принцип работы алгоритма
 *      1) Выбирается начальное значение шага сортировки. К выбору шага стоит отнестись
 * серьезно. От выбора шага зависит средняя сложность сортировки.
 *      2) Начиная от первого элемента выполняется сравнение элементов стоящих друг от
 * друга на расстоянии выбранного шага. Для значения элемента (в дальнейшем X)
 * выбирается место в последовательности таких элементов, что ai≤X≤ai+h
 * h - используемый шаг, ai, ai+h - значение элемента на i индексе, и на i+h индексе соответственно.
 *      3) После окончания прохода с текущим шагом, шаг уменьшают. Если текущий шаг равен
 * 1 алгоритм заканчивают, если нет его уменьшают согласно выбранному закону его
 * изменения и возвращаются к пункту 2.
 */

import java.util.Arrays;

public class ClassicalShellSort {

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
