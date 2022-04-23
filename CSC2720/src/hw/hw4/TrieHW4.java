package hw.hw4;

import java.util.HashMap;
import java.util.Set;

public class TrieHW4 {
	private Node root = new Node(' ');

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

	public int countWordsWithLetters(Set<Character> set) {
		int total = 0;
		for (char c : root.children.keySet()) {
			// for each character at root we check if the character is present in the given
			// set and if it is we will explore all the word with this prefix using a helper
			// function
			if (set.contains(c)) {
				total += countAllWords(root.children.get(c), set);
			}
		}

		return total;
	}

	private int countAllWords(Node node, Set<Character> set) {
		//read through word untill all the chracters are in teh set and if at some point we reach the end of the word
		int count = 0;
		if(node.isEndOfWord)count +=1;

		for(char c:node.children.keySet()){
			if(set.contains(c)){
				count += countAllWords(node.children.get(c),set);
			}
		}

		return count;
	}

}
