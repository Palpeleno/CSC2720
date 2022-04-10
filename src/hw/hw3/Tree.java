package hw.hw3;

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

        @Override
        public String toString() {
            return "node with value = " + value;
        }
    }
    //start here 
    public void printNodesDecreasing() {

    }

    public void printLeaves() {

    }

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

    public int height() {
		return height(root);
	}


	private int height(Node node) {
		if (node == null) {
			return -1;
		}
		return 1 + Math.max(height(node.left), height(node.right));
	}

}