package hw.hw4;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainHW4 {

	public static void main(String[] args) {
		/**
		 * Problem 1
		 */
		System.out.println("Problem 1");
		
		TrieHW4 trie = new TrieHW4();
		List<String> listOfWords = new ArrayList<>(List.of("one", "once", "two", "three", "four"));
		for (String word : listOfWords) {
			trie.insert(word);
		}

		Set<Character> setOfChars = new HashSet<>(List.of('o', 'n', 'c', 'e'));

		Set<Character> setOfAllChars = new HashSet<>();
		for (char character : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
			setOfAllChars.add(character);
		}

		System.out.println(trie.countWordsWithLetters(setOfChars));
		System.out.println(trie.countWordsWithLetters(setOfAllChars));
		
		/**
		 * Problem 2 
		 */
		System.out.println("Problem 2");
		
		final int NUMBER_OF_NODES = 6;
		WeightedUndirectedGraphHW4 graph = new WeightedUndirectedGraphHW4();
		for (int nodeNumber = 1; nodeNumber <= NUMBER_OF_NODES; nodeNumber++) {
			graph.addNode(Integer.toString(nodeNumber));
		}
		graph.addEdge("1", "2", 1);
		graph.addEdge("2", "4", 1);
		graph.addEdge("2", "3", 1);
		graph.addEdge("4", "1", 1);
		graph.addEdge("6", "5", 1);
		System.out.println(graph.isConnected());
		graph.addEdge("3", "5", 1);
		System.out.println(graph.isConnected());
		
		/**
		 * Problem 3 
		 */
		System.out.println("Problem 3");
		
		for (int nodeNumber = 1; nodeNumber <= NUMBER_OF_NODES; nodeNumber++) {
			System.out.println(graph.degree(Integer.toString(nodeNumber)));
		}
		
	}

}
