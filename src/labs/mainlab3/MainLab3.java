package edu.gsu.cs.datastructures;

public class MainLab3 {

	public static boolean isMinHeap(int[] array) {
		
	}

	public static void main(String[] args) {

		/*
		 * Problem 1
		 */
		int[] array = {0,3,2,8,10,9,7};
		System.out.println(isMinHeap(array));
		
		/*
		 * Problems 2 & 3
		 */
		Tree tree = new Tree();
		tree.insert(7);
		tree.insert(4);
		tree.insert(9);
		tree.insert(1);
		tree.insert(5);
		tree.insert(6);
		
		// problem 2 tested
		tree.printNodesDecreasing(); 
		System.out.println();
		
		// problem 3 tested
		tree.printLeaves();
	}

}
