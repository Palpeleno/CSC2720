package labs.lab11;

import java.util.ArrayList;
import java.util.HashMap;

public class Trie {
	private Node root = new Node(' ');
	Trie[] children = new Trie[ALPHABET_SIZE];

	public static final int ALPHABET_SIZE = 26;
	public static int indexs;
	public static Trie base;
	boolean isleaf;

	private class Node {
		private char value;
		private HashMap<Character, Node> children = new HashMap<>();
		private boolean isEndOfWord;

		private Node(char value) {
			this.value = value;
		}

		public boolean hasChild(char ch) {
			return children.containsKey(ch);
		}

		public Node getChild(char ch) {
			return children.get(ch);
		}

		public void addChild(char ch) {
			children.put(ch, new Node(ch));
		}

		public Node[] getChildren() {
			return children.values().toArray(new Node[0]);
		}

		public boolean hasChildren() {
			return !children.isEmpty();
		}

		public void removeChild(char ch) {
			children.remove(ch);
		}
	}

	public void insert(String word) {
		Node current = root;
		for (char ch : word.toCharArray()) {
			if (!current.hasChild(ch)) {
				current.addChild(ch);
			}
			current = current.getChild(ch);
		}
		current.isEndOfWord = true;
	}

	public boolean contains(String word) {
		if (word == null) {
			return false; 	
		}
		Node current = root;
		for (char ch : word.toCharArray()) {
			if (!current.hasChild(ch)) {
				return false;
			}
			current = current.getChild(ch);
		}
		return current.isEndOfWord;
	}

	public void remove(String word) {
		if (word == null) {
			return;
		}
		remove(root, word, 0);
	}

	private void remove(Node node, String word, int idx) {
		if (idx == word.length()) {
			node.isEndOfWord = false;
			return;
		}
		char ch = word.charAt(idx);
		Node child = node.getChild(ch);
		if (child == null) {
			return;
		}
		remove(child, word, idx + 1);
		if (!child.hasChildren() && !child.isEndOfWord) {
			node.removeChild(ch);
		}
	}

	public void traversePreOrder() {
		traversePreOrder(root);
	}

	private void traversePreOrder(Node node) {
		System.out.println(node.value);
		for (Node child : node.getChildren()) {
			traversePreOrder(child);
		}
	}

	public void traversePostOrder() {
		traversePostOrder(root);
	}

	private void traversePostOrder(Node node) {
		for (Node child : node.getChildren()) {
			traversePostOrder(child);
		}
		System.out.println(node.value);
	}

	public ArrayList<String> wordsWithPrefix(String prefix) {
		ArrayList<String> listOfWords = new ArrayList<>();
		Node lastNode = findLastNodeOf(prefix);
		wordsWithPrefix(lastNode, prefix, listOfWords);
		return listOfWords;
	}

	private void wordsWithPrefix(Node node, String prefix, ArrayList<String> listOfWords) {
		if (node == null) {
			return;
		}
		if (node.isEndOfWord) {
			listOfWords.add(prefix);
		}
		for (Node child : node.getChildren()) {
			wordsWithPrefix(child, prefix + child.value, listOfWords);
		}
	}

	private Node findLastNodeOf(String prefix) {
		if (prefix == null) {
			return null;
		}
		Node current = root;
		for (char ch : prefix.toCharArray()) {
			Node child = current.getChild(ch);
			if (child == null) {
				return null;
			}
			current = child;
		}
		return current;


	public static void constructTrie(String arr[]) {
		// takes parameter of a n array of strings puts in new "trie"
		
		Trie trie = new Trie();
		for (String word : arr) {
			trie.insert(word);
		}

		return;
	}

	public String longestCommonPrefix(String[] words) {
		base = new Trie();
		constructTrie(words);
		
		return walkTrie();
	}

	public static int countChildren(Trie node) {
		int count = 0;
		for (int i = 0; i < ALPHABET_SIZE; i++) {
			if (node.children[i] != null) {
				count++;
				indexs = i;
			}
		}
		return (count);
	}

	public static String walkTrie() {
		Trie current = base;
		indexs = 0;
		String prefix = "";

		while (countChildren(current) == 1 &&
				current.isleaf == false) {
			current = current.children[indexs];
			prefix += (char) ('a' + indexs);
		}
		return prefix;
	}

}
