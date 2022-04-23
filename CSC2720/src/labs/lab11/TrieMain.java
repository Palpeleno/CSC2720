package labs.lab11;

import java.util.ArrayList;

public class TrieMain {

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("hello");
		trie.insert("hello");
		trie.insert("hi");
		trie.insert("heist");
		trie.insert("hey");
		trie.insert("doggy");
		trie.insert("dog");
		System.out.println("Does the trie contain doggy");
		System.out.println(trie.contains("doggy"));

		ArrayList<String> list = trie.wordsWithPrefix("dog");
		System.out.println(list);

		String arr[] = { "hello", "hello", "hi", "heist", "hey", "doggy", "dog"};

		System.out.println("The longest common prefix is " + trie.longestCommonPrefix(arr));


		
	}

}
