package edu.gsu.cs.datastructures;

public class Sorting {

	/**
	 * Sorts an array using the insertion sort.
	 * 
	 * @param array is the array of integers to sort
	 */

	public static void insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			insertIntoSortedPartToTheLeftOf(i, array);
		}
	}

	/**
	 * Inserts an element that is located at index ``idx'' in the original array
	 * into the sorted part of the array. The sorted part on the left of the index
	 * ``idx''.
	 * 
	 * @param idx   is the index of the element to insert into the sorted part of
	 *              the array
	 * @param array is the array of integers and is in the process of sorting
	 */

	private static void insertIntoSortedPartToTheLeftOf(int idx, int[] array) {
		int element = array[idx];
		int j = idx - 1;
		while (j >= 0 && array[j] > element) {
			array[j + 1] = array[j--];
		}
		array[j + 1] = element;
	}

	/**
	 * Sorts an array using the merge sort.
	 * 
	 * @param array is the array of integers to sort
	 */

	public static void mergeSort(int[] array) {
		if (array.length <= 1) {
			return;
		}

		int middle = array.length / 2;

		int[] leftArray = new int[middle];
		for (int i = 0; i < leftArray.length; i++) {
			leftArray[i] = array[i];
		}

		int[] rightArray = new int[array.length - middle];
		for (int i = 0; i < rightArray.length; i++) {
			rightArray[i] = array[i + middle];
		}

		mergeSort(leftArray);
		mergeSort(rightArray);

		mergeTwoArrays(leftArray, rightArray, array);
	}

	/**
	 * Merges two (sub)array into the third one.
	 * 
	 * @param leftArray  is the array that will be merged on the left
	 * @param rightArray is the array that will be merged on the right
	 * @param result     is the output array that is the result of merging leftArray
	 *                   with rightArray
	 */

	private static void mergeTwoArrays(int[] leftArray, int[] rightArray, int[] result) {
		int i = 0, j = 0, k = 0;

		while (i < leftArray.length && j < rightArray.length) {
			result[k++] = (leftArray[i] < rightArray[j]) ? leftArray[i++] : rightArray[j++];

//			if (leftArray[i] < rightArray[j]) {
//				result[k] = leftArray[i];
//				i++;
//				k++;
//			} else {
//				result[k] = rightArray[j];
//				j++;
//				k++;
//			}
		}
		while (i < leftArray.length) {
			result[k++] = leftArray[i++];
//			result[k] = leftArray[i];
//			i++;
//			k++;
		}
		while (j < rightArray.length) {
			result[k++] = rightArray[j++];
//			result[k] = rightArray[j];
//			j++;
//			k++;
		}

	}

	/**
	 * Sorts an array using the counting sort.
	 * 
	 * @param array is the array of integers to sort
	 * @param min   is the the minimal value in the array
	 * @param max   is the the maximal value in the array
	 */

	public static void countingSort(int[] array, int min, int max) {
		if (max - min < 0) {
			throw new IllegalArgumentException();
		}
		int[] counts = new int[max - min + 1];
		for (int element : array) {
			counts[element - min]++;
		}
		int idx = 0;
		for (int i = 0; i < counts.length; i++) {
			for (int j = 0; j < counts[i]; j++) {
				array[idx++] = i + min;
			}
		}
	}

}
