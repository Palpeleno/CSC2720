package edu.gsu.cs.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingMain {

	public static void main(String[] args) {
		
		/*
		 * Method 1
		*/
		
		int[] array = { 2, -2, 0, 8, 9, 1, 2, 3, 5 };
		Arrays.sort(array);
		System.out.println("Method 1: " + Arrays.toString(array));
		
		// Impossible to use directly if you need a decreasing order!

		/*
		 * Method 2
		*/
		
		Integer[] array2 = { 2, -2, 0, 8, 7, 3, 2, 3, 5 };
		Arrays.sort(array2);
		System.out.println("Method 2: " + Arrays.toString(array2));
		Arrays.sort(array2, Collections.reverseOrder());
		System.out.println("Method 2: " + Arrays.toString(array2));
		
		/*
		 * Method 3
		*/
		
		List<Integer> arrayList = new ArrayList<>();
		for (int element : new int[] { 2, -2, 0, 8, 9, 1, 2, 3, 5 }) {
			arrayList.add(element);
		}
		Collections.sort(arrayList);
		System.out.println("Method 3: " + arrayList);
		Collections.sort(arrayList, Collections.reverseOrder());
		System.out.println("Method 3: " + arrayList);
		
		
		/*
		 * Sorting objects by one of the fields of a class
		*/
		
		class Node {
			private String label;
			private int weight;
			
			public Node(String label, int weight) {
				this.label = label;
				this.weight = weight;
			}

			@Override
			public String toString() {
				return "[" + label + ", w=" + weight + "]";
			}
		}
		
		List<Node> listOfNodes = new ArrayList<>();
		for (int element : new int[] { 2, 12, 0, 8, 9, 1, 3, 5 }) {
			listOfNodes.add(new Node(Character.toString('Y' - element), element));
		}
		System.out.println("Original nodes: " + listOfNodes);
		Collections.sort(listOfNodes, Comparator.comparingInt(node -> node.weight));
		System.out.println("Sorted by weight nodes: " + listOfNodes);
		
		
		/*
		 * Just a test of our methods
		*/
		int[] arr1 = { 2, -2, 0, 8, 9, 1, 2, 3, 5 };
		int[] arr2 = arr1.clone();
		int[] arr3 = arr1.clone();
		System.out.println("The array 1:\t\t" +  Arrays.toString(arr1));
		Sorting.insertionSort(arr1);
		System.out.println("After Insertion Sort:\t" +  Arrays.toString(arr1));
		
		System.out.println("The array 2:\t\t" +  Arrays.toString(arr2));
		Sorting.mergeSort(arr2);
		System.out.println("After Merge Sort:\t" +  Arrays.toString(arr2));
		
		System.out.println("The array 3:\t\t" +  Arrays.toString(arr3));
		Sorting.countingSort(arr3, -2, 9);
		System.out.println("After Counting Sort:\t" +  Arrays.toString(arr3));
	
	}

}
