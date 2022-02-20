package hw.hw2;

import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		int[] array1 = { 1, 5, 5, 5, 5, 5, 8, 5, 100, 13, 5, 9, 2, 2, 2, 7 };
		System.out.println(majorityElement(array1));

		// int[] array2 = { 1, 4, 10, 13, 15 };
		// System.out.println(pairsWithDifference(3, array2));
		// int[] array3 = { 2, 3, 4, -8, 1, -2, 8, 7 };

		// System.out.println(containsSubarrayWithSum(5, array3));
	}

	// private static char[] containsSubarrayWithSum(int i, int[] array3) {
	// return null;
	// }

	// private static Object pairsWithDifference(int i, int[] array2) {
	// return null;
	// }

	// takes array puts in to hash map( since we know the size of array is not that
	// big) then makes the elemnts the key and counts
	// each element and assigns the value to the key if the element shows up in the
	// key. if it does update by adding 1
	// if a element shows up more than half the times of the amount of elements in
	// the array
	// then return that element as majority element
	// {1, 2, 5, 2, 2, 2, 8, 2, 100, 13, 2, 9, 2, 2, 2, 7 }
	private static int majorityElement(int[] array1) {
		HashMap<Integer, Integer> alpha = new HashMap<>();

		for (int i = 0; i < array1.length; i++) {		//traferse through array
			System.out.println(i);						// debug element

			if (alpha.containsKey(array1[i])) {			//if element exist update counter and moves to next element,
				System.out.println(array1);				// debug element
				int count = alpha.get(array1[i]) + 1;
				if (count > array1.length / 2) {		// if elem exist and more than n/2 print and exit
					System.out.println("majority element: " + array1[i] + "frequency" + count);
					return count;
				} else
					alpha.put(array1[i], count);		

			} else
				alpha.put(array1[i], 1);				// if elem not exist add to hash  
		}
		System.out.println(array1);						// deubg element
		return -1;
	}

}
