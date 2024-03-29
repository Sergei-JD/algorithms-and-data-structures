package com.aads.sort.mergeSort.recursive.objects;

import java.util.Arrays;
import java.util.Comparator;

/**
 *                      Сортировка слиянием. Рекурсивный алгоритм
 *      Сложность по времени в наихудшем случае O(n·ln(n))
 *      Требует дополнительно памяти в размере n
 *
 *                      Принцип работы алгоритма
 *          1) Создается дополнительная последовательность размер которой равен сортируемой
 *      последовательности. Перейти в 2.
 *          2) Последовательность разбивается на две части и для каждой из частей рекурсивно запускается
 *      функция сортировки сначала для левой подпоследовательности, потом для правой. После чего
 *      проводят слияние отсортированных подпоследовательностей. Условием выхода из рекурсии
 *      является размер подпоследовательности равный нулю.
 */

public class MergeSort {

    public static void main(String[] args) {
        String[] array = new String[] { "Python", "Ada", "Java", "C", "Fortran" };
        Comparator<String> comp = (a, b) -> a.length() - b.length();
        mergeSort(array, comp);
        System.out.println(Arrays.toString(array));

    }

    public static <T> void mergeSort(T[] array, Comparator<T> comp) {
        T[] support = Arrays.copyOf(array, array.length);
        int startIndex = 0;
        int endIndex = support.length - 1;
        mergeSort(array, support, comp, startIndex, endIndex);
    }

    public static <T> void mergeSort(T[] array, T[] support, Comparator<T> comp, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int h = startIndex + (endIndex - startIndex) / 2;
        mergeSort(array, support, comp, startIndex, h);
        mergeSort(array, support, comp, h + 1, endIndex);
        merge(array, support, comp, startIndex, h, h + 1, endIndex);
    }

    public static <T> void merge(T[] array, T[] support, Comparator<T> comp, int ls, int le, int rs, int re) {
        for (int i = ls; i <= re; i++) {
            support[i] = array[i];
        }
        int l = ls;
        int r = rs;
        for (int i = ls; i <= re; i++) {
            if (l > le) {
                array[i] = support[r];
                r += 1;
            } else if (r > re) {
                array[i] = support[l];
                l += 1;
            } else if (comp.compare(support[l], support[r]) < 0) {
                array[i] = support[l];
                l += 1;
            } else {
                array[i] = support[r];
                r += 1;
            }
        }
    }
}
