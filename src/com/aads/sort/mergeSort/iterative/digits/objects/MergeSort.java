package com.aads.sort.mergeSort.iterative.digits.objects;

import java.util.Arrays;
import java.util.Comparator;

/**
 *                      Сортировка слиянием. Итерационный алгоритм
 *      Сложность по времени в наихудшем случае O(n·ln(n))
 *      Требует дополнительно памяти в размере n
 *
 *                      Краткие сведения о алгоритме и авторе
 *          Алгоритм был разработан в 1945 г Джоном Фон Нейманом. Этот алгоритм использует подход
 *      «разделяй и властвуй» и может быть использован для сортировки структур данных, доступ к
 *      элементам которых можно получать только последовательно (например внешние файлы).
 *      Джон фон Нейман (1903-1957) венгеро-американский математик, физик и педагог еврейского
 *      происхождения, сделавший важный вклад в квантовую физику, квантовую логику,
 *      функциональный анализ, теорию множеств, информатику, экономику и другие отрасли науки.
 *          Наиболее известен как человек, с именем которого связывают архитектуру большинства
 *      современных компьютеров (так называемая архитектура фон Неймана).
 *
 *                      Принцип работы алгоритма
 *          1) Создается дополнительная последовательность размер которой равен сортируемой
 *      последовательности. Перейти в 2.
 *          2) Устанавливается начальный размер сливаемых последовательностей равный 1. Выполняем
 *      попарное слияние соседних подпоследовательностей указанного размера начиная с начала
 *      последовательности. В случае если для подпоследовательности нет пары, то слияние
 *      производить не нужно (для последовательности нечетной длины). Перейти к 3.
 *          3) Увеличить значение размера в два раза. Если размер больше длинны последовательности
 *      закончить алгоритм. В противном случае перейти к 2.
 */

public class MergeSort {

    public static void main(String[] args) {

        String[] array = new String[] { "Python", "Ada", "Java", "C", "Fortran" };
        Comparator<String> comp = Comparator.comparingInt(String::length);
        mergeSort(array, comp);
        System.out.println(Arrays.toString(array));

    }

    public static <T> void mergeSort(T[] array, Comparator<T> comp) {
        T[] support = Arrays.copyOf(array, array.length);
        int n = array.length;
        for (int size = 1; size < n; size *= 2) {
            for (int j = 0; j < n - size; j += 2 * size) {
                merge(array, support, comp, j, j + size - 1, j + size, Math.min(j + 2 * size - 1, n - 1));
            }
        }
    }

    public static <T> void merge(T[] array, T[] support, Comparator<T> comp, int ls, int le, int rs, int re) {
        if (re + 1 - ls >= 0) System.arraycopy(array, ls, support, ls, re + 1 - ls);
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
