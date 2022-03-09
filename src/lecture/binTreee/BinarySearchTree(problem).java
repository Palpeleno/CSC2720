package edu.gsu.cs.datastructures;

import java.util.LinkedList;

public class BinarySearchTree {
	private Node root;

	private class Node {
		private int value;
		private Node left;
		private Node right;

		public Node(int value) {
			this.value = value;
			this.left = this.right = null;
		}

		@Override
		public String toString() {
			return "node with value = " + value;
		}
	}


	/**
	 * INSERT ITERATIVELY
	 */

	/**
	 * Iteratively inserts a specified a node into the tree.
	 * 
	 * @param value is the value of a node to add
	 */

	public void insert(int value) {
		Node newNode = new Node(value);

		if (root == null) {
			root = newNode;
			return;
		}

		Node current = root;
		while (current != null) {
			if (current.value < value) {
				if (current.right == null) {
					current.right = newNode;
					return;
				}
				current = current.right;
			}
			if (current.value > value) {
				if (current.left == null) {
					current.left = newNode;
					return;
				}
				current = current.left;
			}
		}
	}

	/**
	 * INSERT RECURSIVELY
	 */

	/**
	 * Recursively inserts a specified a node into the tree.
	 * 
	 * @param value is the value of a node to add
	 */

	public void insertRec(int value) {
		root = insertRec(root, value);
	}

	/**
	 * Recursively inserts a specified a node into the (sub)tree with root = node.
	 * 
	 * @param node  is the node that serves as a root of a subtree to which the node
	 *              will be added
	 * @param value is the value of a node to add
	 * @return either the inserted node or the next node on the way from the root to
	 *         the place where the node will be inserted
	 */

	private Node insertRec(Node node, int value) {
		if (node == null) {
			node = new Node(value);
			return node;
		}

		if (node.value < value) {
			node.right = insertRec(node.right, value);
			return node;
		}

		node.left = insertRec(node.left, value);
		return node;
	}
	

	/**
	 * TO STRING (PRINTING THE TREE)
	 */

	/**
	 * Prints the tree into a string.
	 * 
	 * @return a string which contains the structure of the tree
	 */

	@Override
	public String toString() {
		LinkedList<Node> tempTreeLevel = new LinkedList<Node>();
		LinkedList<Node> fullTreeLevel = new LinkedList<Node>();
		fullTreeLevel.add(root);

		int level = 0;
		int height = height();

		StringBuffer toPrint = new StringBuffer();

		while (level <= height) {
			Node current = fullTreeLevel.removeFirst();
			int numberOfTabs = (int) Math.pow(2, height - level);
			if (!tempTreeLevel.isEmpty()) {
				numberOfTabs = numberOfTabs * 2;
			}
			toPrint.append(printNode(numberOfTabs, current));

			if (current == null) {
				tempTreeLevel.add(null);
				tempTreeLevel.add(null);
			}
			if (current != null) {
				tempTreeLevel.add(current.left);
				tempTreeLevel.add(current.right);
			}

			if (fullTreeLevel.isEmpty()) {
				toPrint.append("\n\n");
				fullTreeLevel = tempTreeLevel;
				tempTreeLevel = new LinkedList<>();
				level++;
			}

		}
		return toPrint.toString();
	}

	/**
	 * Prints into a string a node in a proper position.
	 * 
	 * @param numberOfTabs is the number of tabulations in front of the node
	 * @param node         is the the node to print
	 * @return a string with the value of the node printed in the proper position
	 */

	private String printNode(int numberOfTabs, Node node) {
		StringBuffer toPrint = new StringBuffer();
		toPrint.append(printSpaces(numberOfTabs));

		if (node != null) {
			toPrint.append(node.value);
		}

		return toPrint.toString();
	}

	/**
	 * Prints into a string the specified number of tabulations.
	 * 
	 * @param numberOfTabs is the number of tabulations to print
	 * @return a string with the tabulations
	 */

	private String printSpaces(int numberOfTabs) {
		StringBuffer toPrint = new StringBuffer();

		while (numberOfTabs > 0) {
			toPrint.append("\t");
			numberOfTabs--;
		}

		return toPrint.toString();
	}

	/**
	 * HEIGHT
	 */

	/**
	 * Calculates the height of the tree.
	 * 
	 * @return the height of the tree
	 */

	public int height() {
		return height(root);
	}

	/**
	 * Calculates the height of the node.
	 * 
	 * @param node is the node whose height will be calculated
	 * @return the height of the node
	 */

	private int height(Node node) {
		if (node == null) {
			return -1;
		}
		return 1 + Math.max(height(node.left), height(node.right));
	}

}
