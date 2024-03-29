package com.aads.sort.sortingByChoice.customType;

public class SortingByChoiceCustomType {

    public static void main(String[] args) {

        Cat cat1 = new Cat("Vaska", 6);
        Cat cat2 = new Cat("Barsik", 2);
        Cat cat3 = new Cat("Umka", 12);
        Cat cat4 = new Cat("Kuzia", 4);

        Cat[] cats = new Cat[] { cat1, cat2, null, cat3, cat4 };

        for (int i = 0; i < cats.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < cats.length; j++) {
                if (compareCat(cats[minIndex], cats[j]) > 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Cat temp = cats[i];
                cats[i] = cats[minIndex];
                cats[minIndex] = temp;
            }
        }

        for (Cat cat : cats) {
            System.out.println(cat);
        }

    }

    public static int compareCat(Cat a, Cat b) {
        if (a != null && b == null) {
            return 1;
        }
        if (a == null && b != null) {
            return -1;
        }
        if (a == null && b == null) {
            return 0;
        }
        if (a.getAge() > b.getAge()) {
            return 1;
        }
        if (a.getAge() < b.getAge()) {
            return -1;
        }
        return 0;
    }
}
