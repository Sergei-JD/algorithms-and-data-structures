package com.aads.fractionalKnapsack.staticImpl;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void main(String[] args) {
        final Item item1 = new Item(4, 20);
        final Item item2 = new Item(3, 18);
        final Item item3 = new Item(2, 14);

        final Item[] items = {item1, item2, item3};
        // sort O(N * log(N))
        Arrays.sort(items, Comparator.comparingDouble(Item::valuePerUnitOfWeight).reversed());

        System.out.println(Arrays.toString(items));

        final int W = 7;

        int weightSoFar = 0;
        double valueSoFar = 0;
        int currentItem = 0;

        while (currentItem < items.length && weightSoFar != W) {
            if (weightSoFar + items[currentItem].getWeight() < W) {
                // take all object

                valueSoFar += items[currentItem].getValue();
                weightSoFar +=items[currentItem].getWeight();
            } else {
                // take part of object
                valueSoFar += (W - weightSoFar) / (double) items[currentItem].getWeight() *
                        items[currentItem].getValue();

                weightSoFar = W; // full load
            }

            currentItem++;
        }

        System.out.println("The value of the best set: " + valueSoFar);
    }
}

class Item {
    private int weight;
    private int value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public double valuePerUnitOfWeight() {
        return value / (double) weight;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "{w:" + weight + ", v:" + value + "}";
    }
}
