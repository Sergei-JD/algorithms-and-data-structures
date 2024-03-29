package com.aads.combinatorics.combinations.revolvingDoor;

import java.util.Arrays;

/**
 *                  Генерация сочетаний с помощью алгоритма вращающейся двери
 *
 *                  Сведение о алгоритме
 *                      O(n!/(k!(n-k)!))*k)
 *          Затраты памяти O(K+1)
 *          k — элементов выбранных из множества из n - элементов
 *
 *                  Количество сочетаний
 *          Число сочетаний из n по k равно биномиальному коэффициенту:
 *                      (n/k) = n! /(k !(n−k )!)
 *
 *                  Сведение о алгоритме
 *          Алгоритм был разработан W.H.Payne в 1979 году. Суть алгоритма что каждое
 *      сочетание получается путем замены одного (и только одного) элемента сочетания на
 *      элемент из еще не использованных. Называется так потому, как заменяемый элемент
 *      как бы выходит через вращающуюся дверь и в этот же момент через нее добавляется
 *      элемент который еще не использовался.
 *
 *                  Принцип работы алгоритма
 *          Генерируем все сочетания из n целых чисел [0,1,2...n-1] по k.
 *          1) Создаем последовательность размером k+1 элемента (в дальнейшем c). Первые k — элементов
 *      устанавливаем равный индексу элемента. Элемент k+1 устанавливаем равным n-1. Вводим
 *      дополнительную переменную j. Перейти к 2.
 *          2) Возвращаем первые k элементов последовательность как очередное сочетание. Перейти к 3.
 *          3) Возможно два варианта:
 *              ● k — нечетное. В случае если c0 + 1 < c1 установить c0= c0 + 1 перейти к 2. В противном случае
 *          установить j = 1 и перейти к 4.
 *              ● k — четное. В случае если c0 > 0 установить c0 = c0 - 1 перейти к 2. В противном случае
 *          установить j = 1 и перейти к 5.
 *          4) В случае cj > j установить cj = cj-1, cj-1 = j-1 и перейти к 2. В противном случае
 *      установить j = j + 1 и перейти к 5.
 *          5) Если cj + 1 <= cj + 1 установить cj - 1 = cj, cj = cj + 1 и перейти к 2. В противном случае
 *      установить j = j + 1, если j<k перейти к 4. В противном случае закончить алгоритм.
 */

public class revolvingDoorAlgorithm {

    public static void main(String[] args) {

        printAllCombination(3, 5);

    }

    public static void printAllCombination(int k, int n) {
        int[] c = new int[k + 1];
        for (int i = 0; i < k; i++) {
            c[i] = i;
        }
        c[k] = n - 1;
        int step = 2;
        int j = 1;
        while (step != -1) {
            switch (step) {
                case 2 -> {
                    printCurrentCombination(c, k);
                    step = 3;
                }
                case 3 -> {
                    int[] r3 = checkFirstElement(c, k);
                    step = r3[0];
                    j = r3[1];
                }
                case 4 -> {
                    int[] r4 = decreesElement(c, j);
                    step = r4[0];
                    j = r4[1];
                }
                case 5 -> {
                    int[] r5 = enlargementElement(c, j, k);
                    step = r5[0];
                    j = r5[1];
                }
            }
        }
    }

    public static void printCurrentCombination(int[] c, int k) {
        System.out.println(Arrays.toString(Arrays.copyOf(c, k)));
    }

    public static int[] checkFirstElement(int[] c, int k) {
        int step;
        int j = 1;
        if (k % 2 != 0) {
            if (c[0] + 1 < c[1]) {
                c[0] += 1;
                step = 2;
            } else {
                step = 4;
            }
        } else {
            if (c[0] > 0) {
                c[0] -= 1;
                step = 2;
            } else {
                step = 5;
            }
        }
        return new int[] { step, j };
    }

    public static int[] decreesElement(int[] c, int j) {
        int step;
        if (c[j] > j) {
            c[j] = c[j - 1];
            c[j - 1] = j - 1;
            step = 2;
        } else {
            j += 1;
            step = 5;
        }
        return new int[] { step, j };
    }

    public static int[] enlargementElement(int[] c, int j, int k) {
        int step;
        if (c[j] + 1 <= c[j + 1]) {
            c[j - 1] = c[j];
            c[j] += 1;
            step = 2;
        } else {
            j += 1;
            if (j < k) {
                step = 4;
            } else {
                step = -1;
            }
        }
        return new int[] { step, j };
    }
}
