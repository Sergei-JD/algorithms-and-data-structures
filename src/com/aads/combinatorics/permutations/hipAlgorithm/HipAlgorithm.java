package com.aads.combinatorics.permutations.hipAlgorithm;

import java.util.Arrays;

/**
 *                  Генерация перестановок. Алгоритм Хипа
 *
 *          Сложность по времени в наихудшем случае O(n!)
 *
 *                  Описание алгоритма
 *          Для первого вызова функции используем последовательность (из элементов которой хотим
 *      получить перестановки) и значение k равное ее длине.
 *          1) Проверить значение k. В случае если k == 1. Вернуть последовательность как текущую
 *      перестановку. Закончить вызов функции.
 *          2) Используя цикл от индекса первого элемента последовательности до k с шагом в 1 выполнить
 *      действия:
 *              ● Рекурсивно вызвать функцию передав последовательность и значение k-1
 *              ● Если k четное выполнить обмен i и k элемента местами, в противном случае выполнить
 *          обмен первого элемента последовательности и k.
 */

public class HipAlgorithm {

    public static void main(String[] args) {

        int[] array = new int[] { 1, 2, 3 };
        int k = array.length;
        permutation(array, k);

    }

    public static void permutation(int[] array, int k) {
        if (k == 1) {
            System.out.println(Arrays.toString(array));
            return;
        }
        for (int i = 0; i < k; i++) {
            permutation(array, k - 1);
            int temp;
            if (k % 2 == 0) {
                temp = array[i];
                array[i] = array[k - 1];
            } else {
                temp = array[0];
                array[0] = array[k - 1];
            }
            array[k - 1] = temp;
        }
    }

}
