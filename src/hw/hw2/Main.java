package hw.hw2;

import java.util.Arrays;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {

		System.out.println("\n");

		int[] array1 = { 1, 2, 5, 2, 2, 2, 8, 2, 100, 13, 2, 9, 2, 2, 2, 7 };
		System.out.println(majorityElement(array1));

		System.out.println("\n");

		int[] array2 = { 1, 4, 10, 13, 15, 16 };
		System.out.println(pairsWithDifference(3, array2));

		System.out.println("\n");

		int[] array3 = { 1, 1, 1, 1, 1, 2, 3, 4, -8, 1, -2, 8, 7 };
		System.out.println(containsSubarrayWithSum(3, array3));
	}

	// this is method 3

	// what we going to do is go thorught the array and only add it to hash map for
	// every element. for every element i want to update the currentsum added to teh
	// value at the index i
	// and then check if the currentsum- the desired sum = 0
	// if it equal zero that mean it evens out and all the elements prior helped get
	// that will have been added to the hashmap, the hash map will only include the
	// first set of elements that help get the sum.
	// true if array has a set in which equal the sum
	// false otherwise
	//
	// { 2, 3, 4, -8, 1, -2, 8, 7 } sum is 5 in this case
	//
	private static boolean containsSubarrayWithSum(int sum, int[] array3) {
		int current_sum = 0;
		int start = 0;
		int end = -1;

		HashMap<Integer, Integer> tikka = new HashMap<>();

		for (int i = 0; i < array3.length; i++) {
			// System.out.println("current_sum=" + current_sum); //debug element
			current_sum = current_sum + array3[i];
			// System.out.println("@" + i + "=" + array3[i]); // debug element
			// System.out.println("current sum=" + current_sum); // debug element

			// check whether current_sum - sum = 0, if 0 it means
			// the sub array is starting from index 0- so stop
			if (current_sum - sum == 0) {
				start = 0;
				end = i;
				break;
			}
			// if hashMap already has the value, means we already
			// have subarray with the sum - so stop
			if (tikka.containsKey(current_sum - sum)) {
				start = tikka.get(current_sum - sum) + 1;
				end = i;
				break;
			}
			// if value is not present then add to hashmap
			tikka.put(current_sum, i);
			// System.out.println(tikka); //debug element

		}
		// if end is -1 : means we have reached end without the sum
		if (end == -1) {
			System.out.println("No subarray with given sum exists");
			return false;
		} else {
			System.out.println("Sum found between indexes "
					+ start + " to " + end);
			return true;
		}
	}

	// this is method 2

	// counts the number of distinct inordered pairs of integers that have a
	// diffrence
	// equal to or greater than one.
	// input is the number "d"that is the amount of diffrence we want from the out
	// put pairs
	// other input is the array
	// iterate through array get first array element, add/ subtract the "d". then
	// search the hash map for those two numbers if they exist add them to a hash
	// map key value pair
	// { 1, 4, 10, 13, 15 }
	private static int pairsWithDifference(int d, int[] array2) {
		HashMap<Integer, Integer> dosa = new HashMap<>();

		Arrays.sort(array2); // Sort array elements

		// System.out.println(array2.length); // debug element
		int l = 0;
		int r = 0;
		while (r < array2.length) {

			// System.out.println(array2[r] + array2[l] +"="+ d); //debug element
			if (array2[r] - array2[l] == d) {
				dosa.put(array2[r], array2[l]);
				l++;
				r++;
				// System.out.println(dosa); // debug element
			} else if (array2[r] - array2[l] > d)
				l++;
			else // arr[r] - arr[l] < sum
				r++;
		}
		System.out.println(dosa + "\nhave diffrence of");
		return d;

	}

	// this is method 1

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
			// System.out.println("i=" + i); // debug element

			if (panipuri.containsKey(array1[i])) { // if element exist update counter and moves to next element,
				// System.out.println(panipuri); // debug element
				int count = panipuri.get(array1[i]) + 1;
				if (panipuri.containsValue((array1.length / 2))) { // if elem exist and more than n/2 print and exit
					System.out.println("majority element: " + array1[i] + '\n' + "frequency");
					return count;
				} else
					panipuri.put(array1[i], count); // if count not larger than length thenupdate key/ value

			} else
				panipuri.put(array1[i], 1); // if elem not exist add to hash
			// System.out.println(panipuri); // debug element
		}
		// System.out.println(panipuri); // deubg element
		return -1; // if loop ends and makes it here that means there is no majorityelement
	}

}
