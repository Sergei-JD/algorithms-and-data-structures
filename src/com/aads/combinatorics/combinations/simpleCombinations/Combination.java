package com.aads.combinatorics.combinations.simpleCombinations;

/**
 *                  Генерация сочетаний
 *          Сложность по времени в наихудшем случае
 *                  O(n!/(k!(n-k)!))*(k/(n-k+1))
 *          Затраты памяти O(K+2)
 *          k — элементов выбранных из множества из n - элементов
 *
 *                  Количество сочетаний
 *          Число сочетаний из n по k равно биномиальному коэффициенту:
 *                  (n/k) = n! /(k !(n−k )!)
 *
 *                  Сочетание
 *          Сочетание из n по k - набор k элементов, выбранных из данного множества,
 *      содержащего n различных элементов. Наборы, отличающиеся только порядком
 *      следования элементов (но не составом), считаются одинаковыми. Т.е. порядок элементов
 *      не важен.
 *
 *                  Принцип работы алгоритма
 *          Генерируем все сочетания из n целых чисел [0,1,2...n-1] по k.
 *          1) Создаем последовательность размером k+2 элемента. Первые k — элементов
 *      устанавливаем равный индексу элемента. Элемент k+1 устанавливаем равным n, k+2
 *      — равный 0.
 *          2) Начиная с начала последовательности проверяем условие ki+1 = ki+1. Если это так, то
 *      устанавливаем элемент равный его индексу. Как только это условие нарушено, то
 *      переходим к пункту 3.
 *          3) Если индекс элемента где нарушено условие больше k заканчиваем алгоритм, если
 *      нет то увеличиваем элемент, на который указывает индекс, на единицу.
 *      Возвращаемся к пункту 2.
 */

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