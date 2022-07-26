package com.aads.combinatorics.combinations.lexicographicOrder;

import java.util.Arrays;

/**
 *                  Генерация сочетаний
 *          Сложность по времени в наихудшем случае
 *                  O(n!/(k!(n-k)!))*(n+1/(n+1-k))
 *          Затраты памяти O(K)
 *          k — элементов выбранных из множества из n - элементов
 *
 *                  Принцип работы алгоритма
 *          1) Создаем последовательность (в дальнейшем a) размером k элементов. Индексация в
 *      последовательности начинается с нуля. Заполняем последовательность значениями
 *      от 1 до k. Переходим к пункту 2.
 *          2) Используем последовательность как очередное сочетание. Переходим к пункту 3.
 *          3) Начиная с конца последовательности ищем такой элемент, что выполняется условие
 *      a[i] ≤ n-k+i. Если такой элемент найден то переходим у пункту 4. В противном случае
 *      заканчиваем алгоритм.
 *          4)Увеличиваем найденный элемент на единицу. От найденного элемента и до конца
 *      последовательности устанавливаем значения на единицу больше предыдущего
 *      элемента. Переходим к пункту 2.
 */

public class LexicographicOrder {

    public static void main(String[] args) {

        printCombination(3, 5);

    }

    public static void printCombination(int k, int n) {
        int[] comb = new int[k];
        for (int i = 0; i < comb.length; i++) {
            comb[i] = i + 1;
        }
        for (;;) {
            System.out.println(Arrays.toString(comb));
            int m = -1;
            for (int i = k - 1; i >= 0; i--) {
                if (comb[i] <= n - k + i) {
                    comb[i] += 1;
                    m = i;
                    break;
                }
            }
            if (m == -1) {
                break;
            }
            for (int i = m + 1; i < k; i++) {
                comb[i] = comb[i - 1] + 1;
            }
        }
    }

}