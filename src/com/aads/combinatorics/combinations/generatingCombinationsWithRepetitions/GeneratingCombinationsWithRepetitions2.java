package com.aads.combinatorics.combinations.generatingCombinationsWithRepetitions;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class GeneratingCombinationsWithRepetitions2 {

	public static void main(String[] args) {

		String[] array = new String[] { "A", "B", "C", "D" };
		for (String[] comb : new CombinationGenerator<>(array, 3)) {
			System.out.println(Arrays.toString(comb));
		}

	}

}

class CombinationGenerator<T> implements Iterable<T[]> {
	private int[] combination;
	private T[] array;
	private int k;
	private int n;

	public CombinationGenerator(T[] array, int k) {
		super();
		this.combination = new int[k];
		this.k = k;
		this.n = array.length;
		this.array = Arrays.copyOf(array, n);
	}

	private int[] nextCombination(int[] comb, int n) {
		int i = comb.length - 1;
		for (; i > -1 && comb[i] >= n - 1;) {
			i = i - 1;
		}
		if (i == -1) {
			return null;
		}
		comb[i] += 1;
		for (int j = i + 1; j < comb.length; j++) {
			comb[j] = comb[i];
		}
		return comb;
	}

	@Override
	public Iterator<T[]> iterator() {
		class CombinationIterator implements Iterator<T[]> {

			@Override
			public boolean hasNext() {
				return combination != null;
			}

			@Override
			public T[] next() {
				if (hasNext()) {
					T[] result = Arrays.copyOf(array, k);
					for (int i = 0; i < combination.length; i++) {
						result[i] = array[combination[i]];
					}
					combination = nextCombination(combination, n);
					return result;
				} else {
					throw new NoSuchElementException();
				}
			}
		}
		return new CombinationIterator();
	}
}
