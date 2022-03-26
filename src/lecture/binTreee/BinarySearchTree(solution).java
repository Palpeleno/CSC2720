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
	 * FIND ITERATIVELY
	 */

	/**
	 * Finds a specified a node in the tree. Does it iteratively.
	 * 
	 * @param value is the value of a node to search
	 * @return {@code true} if the node was found, or {@code false} if the node was
	 *         not found
	 */

	public boolean findValue(int value) {
		Node current = root;

		while (current != null) {
			if (current.value < value) {
				current = current.right;
				continue;
			}
			if (current.value > value) {
				current = current.left;
				continue;
			}
			if (current.value == value) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Finds a specified a node in the tree. Does it iteratively.
	 * 
	 * @param value is the value of a node to search
	 * @return the pointer to the node with the value = value, or {@code null} if
	 *         the node was not found
	 */

	public Node findNode(int value) {
		Node current = root;

		while (current != null) {
			if (current.value < value) {
				current = current.right;
				continue;
			}
			if (current.value > value) {
				current = current.left;
				continue;
			}
			if (current.value == value) {
				return current;
			}
		}
		return null;
	}

	/**
	 * FIND RECURSIVELY
	 */

	/**
	 * Finds a specified a node in the tree. Does it recursively.
	 * 
	 * @param value is the value of a node to search
	 * @return {@code true} if the node was found, or {@code false} if the node was
	 *         not found
	 */

	public boolean findValueRec(int value) {
		return findValueRec(root, value);
	}

	/**
	 * Finds a specified a node in the (sub)tree with root = node. Does it
	 * recursively.
	 * 
	 * @param node  is the node that serves as a root of a subtree in which the node
	 *              will be searched
	 * @param value is the value of a node to search
	 * @return {@code true} if the node was found, or {@code false} if the node was
	 *         not found
	 */

	private boolean findValueRec(Node node, int value) {
		if (node == null) {
			return false;
		}

		if (node.value == value) {
			return true;
		}

		if (node.value < value) {
			return findValueRec(node.right, value);
		}

		return findValueRec(node.left, value);
	}

	/**
	 * Finds a specified a node in the tree. Does it recursively.
	 * 
	 * @param value is the value of a node to search
	 * @return the pointer to the node with the value = value, or {@code null} if
	 *         the node was not found
	 */

	public Node findNodeRec(int value) {
		return findNodeRec(root, value);
	}

	/**
	 * Finds a specified a node in the (sub)tree with root = node. Does it
	 * recursively.
	 * 
	 * @param node  is the node that serves as a root of a subtree in which the node
	 *              will be searched
	 * @param value is the value of a node to search
	 * @return the pointer to the node with the value = value, or {@code null} if
	 *         the node was not found
	 */

	private Node findNodeRec(Node node, int value) {
		if (node == null || node.value == value) {
			return node;
		}

		if (node.value < value) {
			return findNodeRec(node.right, value);
		}

		return findNodeRec(node.left, value);
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
