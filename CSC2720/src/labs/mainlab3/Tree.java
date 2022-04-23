package edu.gsu.cs.datastructures;

public class Tree {
	private Node root;

	private class Node {
		private int value;
		private Node left;
		private Node right;

		public Node(int value) {
			this.value = value;
			this.left = this.right = null;
		}
	}

	public void insert(int value) {
		root = insert(root, value);
	}

	private Node insert(Node node, int value) {
		if (node == null) {
			node = new Node(value);
			return node;
		}

		if (node.value < value) {
			node.right = insert(node.right, value);
			return node;
		}

		node.left = insert(node.left, value);
		return node;
	}
	
}
