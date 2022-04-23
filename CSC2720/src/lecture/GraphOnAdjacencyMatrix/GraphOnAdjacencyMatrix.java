package edu.gsu.cs.datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GraphOnAdjacencyMatrix {
	private Map<String, Integer> nodes = new HashMap<>();
	private int nNodes;
	private ArrayList<ArrayList<Integer>> adjacencyMatrix = new ArrayList<ArrayList<Integer>>();

	/**
	 * Adds a node to the graph.
	 * 
	 * @param label  is the label of the node to add
	 */
	
	public void addNode(String label) {
		nodes.putIfAbsent(label, nNodes);

		for (int i = 0; i < nNodes; i++) {
			adjacencyMatrix.get(i).add(0);
		}
		adjacencyMatrix.add(new ArrayList<Integer>());
		for (int j = 0; j <= nNodes; j++) {
			adjacencyMatrix.get(nNodes).add(0);
		}
		nNodes++;
	}
	
	/**
	 * Adds an edge to the graph.
	 * 
	 * @param one  is the label of the first node on the edge to add
	 * @param two  is the label of the second node on the edge to add
	 */

	public void addEdge(String one, String two) {
		Integer idxOne = nodes.get(one);
		Integer idxTwo = nodes.get(two);
		if (idxOne == null || idxTwo == null) {
			throw new IllegalArgumentException("No such node exists!");
		}
		adjacencyMatrix.get(idxOne).set(idxTwo, 1);
		adjacencyMatrix.get(idxTwo).set(idxOne, 1);
	}
	
	/**
	 * Deletes a node to from the graph.
	 * 
	 * @param label  is the label of the node to delete
	 */

	public void removeNode(String label) {
		Integer idxToRemove = nodes.get(label);

		if (idxToRemove == null) {
			return;
		}

		for (var entry : nodes.entrySet()) {
			int idx = entry.getValue();
			if (idx > idxToRemove) {
				entry.setValue(idx - 1);
			}
		}

		for (int i = 0; i < nNodes; i++) {
			adjacencyMatrix.get(i).remove(idxToRemove.intValue());
		}

		adjacencyMatrix.remove(idxToRemove.intValue());
		nodes.remove(label);
		nNodes--;
	}
	
	/**
	 * Deletes an edge from the graph.
	 * 
	 * @param one  is the label of the first node on the edge to delete
	 * @param two  is the label of the second node on the edge to delete
	 */

	public void removeEdge(String one, String two) {
		Integer idxOne = nodes.get(one);
		Integer idxTwo = nodes.get(two);
		if (idxOne == null || idxTwo == null) {
			return;
		}
		adjacencyMatrix.get(idxOne).set(idxTwo, 0);
		adjacencyMatrix.get(idxTwo).set(idxOne, 0);
	}
	
	/**
	 * Finds is two nodes are adjacent.
	 * 
	 * @param one  is the label of the first node
	 * @param two  is the label of the second node
	 * 
	 * @return {@code true} if the nodes are adjacent, 
	 * 			or {@code false} if the nodes are not adjacent
	 */
	
	public boolean areAdjacent(String one, String two) {
		Integer idxOne = nodes.get(one);
		Integer idxTwo = nodes.get(two);
		if (adjacencyMatrix.get(idxOne).get(idxTwo) == 0) {
			return false;
		}
		return true;
	}
	
	/**
	 * TO STRING (PRINTING THE GRAPH)
	 */

	/**
	 * Prints into a string the adjacency matrix of the graph.
	 * 
	 * @return a string which contains the adjacency matrix of the graph
	 */
	
	@Override
	public String toString() {
		StringBuffer toPrint = new StringBuffer();
		for (int i = 0; i < nNodes; i++) {
			toPrint.append(adjacencyMatrix.get(i) + "\n");
		}
		return toPrint.toString();
	}
	
	/**
	 * For each node of the graph, prints a list of labels of its adjacent nodes.
	 */
	
	public void printNodes() {
		for (String labelOne : nodes.keySet()) {
			System.out.print(labelOne + " -> ");
			int row = nodes.get(labelOne);
			for (String labelTwo : nodes.keySet()) {
				int column = nodes.get(labelTwo);
				int elem = adjacencyMatrix.get(row).get(column);
				if (elem == 1) {
					System.out.print(labelTwo + " ");
				}
			}
			System.out.println();
		}
	}
	
	/**
	 * For each node of the graph, prints a list of its incident edges.
	 */
	
	public void printEdges() {
		for (String labelOne : nodes.keySet()) {
			System.out.print(labelOne + " -> ");
			int row = nodes.get(labelOne);
			for (String labelTwo : nodes.keySet()) {
				int column = nodes.get(labelTwo);
				int elem = adjacencyMatrix.get(row).get(column);
				if (elem == 1) {
					System.out.print("{" + labelOne + "," + labelTwo + "} ");
				}
			}
			System.out.println();
		}
	}

}
