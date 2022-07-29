package com.aads.combinatorics.partitions.lexicographicOrder;

import java.util.Arrays;

/**
 *                  Генерация разбиения числа в лексикографическом порядке
 *
 *                  Сведение о алгоритме
 *          Сложность по времени в наихудшем случае O(n)
 *          Затраты памяти O(n)
 *          Внимание это на одно разбиение!!!
 *
 *                  Разбиение целого числа
 *           Разбиение числа n - это представление n в виде суммы положительных целых
 *      чисел, называемых частями. При этом порядок следования частей не учитывается, то
 *      есть разбиения, отличающиеся только порядком частей, считаются равными.
 *      Пример разбиений числа 5:
 *              1){1,1,1,1,1}
 *              2){2,1,1,1}
 *              3){2,2,1}
 *              4){3,1,1}
 *              5){3,2}
 *              6){4,1}
 *              7){5}
 *
 *                  Количество разбиений числа
 *           Асимптотическое выражение для количества разбиений при n→∞
 *              P(n)∼((exp(π⋅√2/3)(√n−1/24)/(4n√3)
 *
 *                  Описание алгоритма
 *          1)Создаем последовательность длинной n. Заполняем ее единицами. Переходим к 2.
 *          2)Если длинна последовательности равна 1 заканчиваем алгоритм. В противном
 *      случае последовательность есть следующее разбиение. Используем его и
 *      переходим к 3.
 *          3)Находим ближайший к началу последовательности минимальный элемент (поиск
 *      проводим от начала до предпоследнего элемента). Увеличиваем его на единицу.
 *      Уменьшаем на единицу последний элемент последовательности. Вычисляем сумму
 *      элементов правее найденного минимального элемента. Создаем новую
 *      последовательность из элементов предыдущей последовательности начиная с
 *      начала и до найденного минимального и такого количества единиц как найденная
 *      ранее сумма. Переходим к 2.
 */

public class GeneratingNumberPartitionsInLexicographicOrder {


    public static void main(String[] args) {
        int number = 5;
        printAllNumberPartitions(number);

    }

    public static int[] getNextPartition(int[] partition) {
        if (partition.length == 1) {
            return null;
        }
        int minIndex = 0;
        for (int i = 0; i < partition.length - 1; i++) {
            if (partition[i] < partition[minIndex]) {
                minIndex = i;
            }
        }
        partition[minIndex] += 1;
        partition[partition.length - 1] -= 1;
        minIndex += 1;
        int partSum = 0;
        for (int i = minIndex; i < partition.length; i++) {
            partSum += partition[i];
        }
        int[] nextPartition = Arrays.copyOf(partition, minIndex + partSum);
        for (int i = minIndex; i < nextPartition.length; i++) {
            nextPartition[i] = 1;
        }
        return nextPartition;
    }

    public static void printAllNumberPartitions(int number) {
        int[] partition = new int[number];
        Arrays.fill(partition, 1);
        while (partition != null) {
            System.out.println(Arrays.toString(partition));
            partition = getNextPartition(partition);
        }
    }
}
