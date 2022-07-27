package com.aads.combinatorics.combinations.generatingCombinationsWithRepetitions;

import java.util.Arrays;

/**
 *                  Генерация сочетаний с повторениями
 *          Сведение о алгоритме
 *                  Сложность по времени в наихудшем случае O(k)
 *                  Внимание это для одного сочетания
 *
 *                  Сочетание
 *          Сочетание из n по k - набор k элементов, выбранных из данного множества,
 *      содержащего n различных элементов. Наборы, отличающиеся только порядком
 *      следования элементов (но не составом), считаются одинаковыми. Т.е. порядок элементов
 *      не важен. Сочетания с повторениями предполагают возможность выбора элемента
 *      множества более одного раза.
 *
 *                  Принцип работы алгоритма
 *          Генерируем все сочетания с повторениями из n целых чисел [0,1,2...n-1] по k.
 *              1)Создаем последовательность размером k элементов. Устанавливаем значения равные 0.
 *          Переходим к 2.
 *              2)Возвращаем полученную последовательность. Переходим к 3.
 *              3)Начиная с конца последовательности выполняем поиск элемента значение которого
 *          меньше чем n-1 (a[i]<n-1). Если поиск неудачен закончить алгоритм. В противном
 *          случае перейти к пункту 4.
 *              4)Увеличить найденный элемент на единицу (a[i]=a[i]+1). Начиная со следующего
 *          элемента и до конца последовательности установить значения равные a[i]. Перейти к
 *          пункту 2.
 */

public class GeneratingCombinationsWithRepetitions1 {

    public static void main(String[] args) {

        printAllCombination(4, 3);

    }

    public static int[] nextCombination(int[] combination, int n) {
        int i = combination.length - 1;
        while (i > -1 && combination[i] >= n - 1) {
            i = i - 1;
        }
        if (i == -1) {
            return null;
        }
        combination[i] += 1;
        for (int j = i + 1; j < combination.length; j++) {
            combination[j] = combination[i];
        }
        return combination;
    }

    public static void printAllCombination(int n, int k) {
        int[] combination = new int[k];
        for (; combination != null;) {
            System.out.println(Arrays.toString(combination));
            combination = nextCombination(combination, n);
        }
    }
}
