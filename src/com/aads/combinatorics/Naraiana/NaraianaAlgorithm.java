package com.aads.combinatorics.Naraiana;

import java.util.Arrays;

/**
 *                  Генерация перестановок в лексикографическом порядке.
 *                  Алгоритм Нарайаны.
 *
 *          Сложность по времени в наихудшем случае O(n)
 *          Затраты памяти O(n)
 *
 *          Внимание!! Это сложность генерации одной (следующей в лексикографическом
 *      порядке) перестановки. Генерация всех перестановок имеет факториальную сложность.
 *
 *                  Применения алгоритма Нарайаны для генерации всех перестановок
 *          Для генерации всех перестановок длинной n с использованием алгоритма
 *      Нарайаны, можно использовать такой алгоритм.
 *          1)Начинаем с базовой перестановки 1, 2, 3... n.
 *          2)Ищем максимальный индекс элемента сосед которого справа больше его. Если
 *      такого индекса нет прекращаем работу алгоритма.
 *          3)Генерируем следующую перестановку используя алгоритм Нарайаны.
 *          4)Используем полученную перестановку в пункте 2.
 *
 *                  Описание алгоритма
 *          1) Найти такой максимальный индекс i для которого Ai < Ai+1 (оптимально выполнять поиск с конца перестановки).
 *          2) Найти максимальный индекс j для которого Aj > Ai (оптимально выполнять поиск с конца перестановки).
 *          3) Выполнить обмен Ai и Aj элемента местами
 *          4) Записать последовательность Ai+1,..., An в обратном порядке
 */

public class NaraianaAlgorithm {

    public static void main(String[] args) {

        permutationGenerator(3);

    }

    public static int findMaxIndex(int[] permutation) {
        for (int i = permutation.length - 2; i >= 0; i--) {
            if (permutation[i] < permutation[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    public static int findIndexBiggerElement(int[] permutation, int element) {
        for (int i = permutation.length - 1; i >= 0; i--) {
            if (permutation[i] > element) {
                return i;
            }
        }
        return -1;
    }

    public static void swap(int[] permutation, int i, int j) {
        int temp = permutation[i];
        permutation[i] = permutation[j];
        permutation[j] = temp;
    }

    public static void reverse(int[] permutation, int index) {
        int shift = index + 1;
        for (int i = 0; i < (permutation.length - shift) / 2; i++) {
            int temp = permutation[shift + i];
            permutation[shift + i] = permutation[permutation.length - i - 1];
            permutation[permutation.length - i - 1] = temp;
        }
    }

    public static void permutationGenerator(int n) {
        int[] permutation = new int[n];
        for (int i = 0; i < permutation.length; i++) {
            permutation[i] = i + 1;
        }
        System.out.println(Arrays.toString(permutation));
        int index = findMaxIndex(permutation);
        while (index != -1) {
            int element = permutation[index];
            int swapIndex = findIndexBiggerElement(permutation, element);
            swap(permutation, index, swapIndex);
            reverse(permutation, index);
            System.out.println(Arrays.toString(permutation));
            index = findMaxIndex(permutation);
        }
    }

}
