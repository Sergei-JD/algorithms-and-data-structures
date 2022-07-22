package com.aads.combinatorics.ehrlichExchangeMethod;

import java.util.Arrays;

/**
 *                  Генерация перестановок. Метод обмена Эрлиха
 *
 *          Сложность по времени в наихудшем случае O(n)
 *          Внимание для одной перестановки !
 *
 *          Внимание!! Это сложность генерации одной (следующей в лексикографическом
 *      порядке) перестановки. Генерация всех перестановок имеет факториальную сложность.
 *
 *                  Описание алгоритма
 *          1) Создать две вспомогательные последовательности. Длинна первой равна длине базовой
 *      последовательности (в дальнейшем b). Длинна второй на один элемент больше (в дальнейшем
 *      c). Заполнить последовательность b числами от 0 и далее по возрастанию с шагом 1. Заполнить c
 *      нулями. Объявить переменную k=1, j=1. Перейти к пункту 2.
 *          2) Вернуть базовую последовательность как очередную перестановку. Перейти к пункту 3.
 *          3) Присвоить k=1. Выполняем проход от начала последовательности до тех пор пока c[k]=k. На
 *      каждом шаге устанавливаем c[k] = 0. По окончанию прохода проверяем если k = n закончить
 *      алгоритм. В противном случае c[k]=c[k]+1 и перейти к пункту 4.
 *          4) Выполнить обмен a[0] <-> a[b[k]]. Перейти к 5.
 *          5) Установить j=1, k = k -1. До тех пор пока j < k выполнять обмен b[j] <-> b[k] установить j = j + 1, k = k-
 *      1. Вернуться к 2.
 */

public class EhrlichExchangeMethod {

    public static void main(String[] args) {

        String[] array = new String[] { "1", "2", "3", "4" };

        printAllPermutation(array);

    }

    public static <T> void printAllPermutation(T[] array) {
        T[] aSequence = Arrays.copyOf(array, array.length);
        int[] bTable = new int[aSequence.length];
        int[] cTable = new int[aSequence.length + 1];
        int k;
        int j;
        for (int i = 0; i < bTable.length; i++) {
            bTable[i] = i;
        }
        for (;;) {
            System.out.println(Arrays.toString(aSequence));
            k = 1;
            while (cTable[k] == k) {
                cTable[k++] = 0;
            }
            if (k == aSequence.length) {
                break;
            }
            cTable[k] += 1;
            swap(aSequence, 0, bTable[k]);
            j = 1;
            k = k - 1;
            while (j < k) {
                swap(bTable, k--, j++);
            }
        }
    }

    public static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
