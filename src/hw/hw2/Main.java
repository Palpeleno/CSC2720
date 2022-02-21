package hw.hw2;

import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		int[] array1 = { 1, 2, 5, 2, 2, 2, 8, 2, 100, 13, 2, 9, 2, 2, 2, 7 };
		System.out.println(majorityElement(array1));

		int[] array2 = { 1, 4, 10, 13, 15 };
		System.out.println(pairsWithDifference(3, array2));

		// int[] array3 = { 2, 3, 4, -8, 1, -2, 8, 7 };
		// System.out.println(containsSubarrayWithSum(5, array3));
	}

	// private static char[] containsSubarrayWithSum(int i, int[] array3) {
	// return null;
	// }

	// counts the number of distinct inordered pairs of integers that have a
	// diffrence
	// equal to or greater than one.
	// input is the number "d"that is the amount of diffrence we want from the out
	// put pairs
	// other input is the array
	// iterate through array get first array element, add/ subtract the "d". then
	// search the hash map for those two numbers if they exist add them to a hash
	// map key value pair
	private static int pairsWithDifference(int d, int[] array2) {
		if (d >= 1) {
			// int count = 0;  // Initialize count
			HashMap<Integer, Integer> dosHashMap = new HashMap<>();

			for (int i = 0; i < array2.length; i++) {
				if (dosHashMap.containsKey(array2[i])) {
					
				} else {
					
					
				}
			}

		} else
			System.out.println("diffrence cannot be less than uqal to 1, you had a \n diffrence of : ");
		return d;

	}

	// takes array puts in to hash map( since we know the size of array is not that
	// big) then makes the elemnts the key and counts
	// each element and assigns the value to the key if the element shows up in the
	// key. if it does update by adding 1
	// if a element shows up more than half the times of the amount of elements in
	// the array
	// then return that element as majority element
	// {1, 2, 5, 2, 2, 2, 8, 2, 100, 13, 2, 9, 2, 2, 2, 7 }
	private static int majorityElement(int[] array1) {
		HashMap<Integer, Integer> panipuri = new HashMap<>();

		for (int i = 0; i < array1.length; i++) { // traverse through array
			System.out.println("i=" + i); // debug element

			if (panipuri.containsKey(array1[i])) { // if element exist update counter and moves to next element,
				System.out.println(panipuri); // debug element
				int count = panipuri.get(array1[i]) + 1;
				if (panipuri.containsValue((array1.length / 2))) { // if elem exist and more than n/2 print and exit
					System.out.println("majority element: " + array1[i] + '\n' + "frequency");
					return count;
				} else
					panipuri.put(array1[i], count); // if count not larger than length then update key/ value

			} else
				panipuri.put(array1[i], 1); // if elem not exist add to hash
			System.out.println(panipuri); // debug element
		}
		System.out.println(panipuri); // deubg element
		return -1; // if loop ends and makes it here that means there is no majority element
	}

}
