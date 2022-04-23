package edu.gsu.cs.datastructures;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class WeightedDirectedGraph {
	private Map<String, Node> nodes = new HashMap<>();

	private class Node {
		private String label;
		private List<Node> adjacentNodes = new ArrayList<>();
		private List<Edge> incidentEdges = new ArrayList<>();

		public Node(String label) {
			this.label = label;
		}

		public void addEdge(Node to, int weight) {
			if (!adjacentNodes.contains(to)) {
				adjacentNodes.add(to);
				incidentEdges.add(new Edge(this, to, weight));
			}
		}

		public void removeEdge(Node to) {
			Edge edgeToRemove = null;
			for (Edge edge : incidentEdges) {
				if (edge.from == this && edge.to == to) {
					edgeToRemove = edge;
					break;
				}
			}
			adjacentNodes.remove(to);
			incidentEdges.remove(edgeToRemove);
		}
		
		public List<Node> getAdjacentNodes() {
			return adjacentNodes;
		}

		public List<Edge> getInsidentEdges() {
			return incidentEdges;
		}

		@Override
		public String toString() {
			return label;
		}
	}

	private class Edge {
		private Node from;
		private Node to;
		private int weight;

		public Edge(Node from, Node to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "{" + from + "," + to + ":w=" + weight + "}";
		}
	}

	/**
	 * Returns a collection of all nodes in the graph.
	 * 
	 * @return a collection of nodes
	 */

	private Collection<Node> getAllNodes() {
		return nodes.values();
	}

	/**
	 * Adds a node to the graph.
	 * 
	 * @param label is the label of the node to add
	 */

	public void addNode(String label) {
		nodes.putIfAbsent(label, new Node(label));
	}

	/**
	 * Adds an edge to the graph.
	 * 
	 * @param from   is the label of the first node on the edge to add
	 * @param to     is the label of the second node on the edge to add
	 * @param weight is the weight of the edge to add
	 */

	public void addEdge(String fromLabel, String toLabel, int weight) {
		Node from = nodes.get(fromLabel);
		Node to = nodes.get(toLabel);
		if (from == null || to == null) {
			throw new IllegalArgumentException("No such node exists!");
		}
		from.addEdge(to, weight);
	}

	/**
	 * Deletes a node to from the graph.
	 * 
	 * @param label is the label of the node to delete
	 */

	public void removeNode(String label) {
		Node nodeToRemove = nodes.get(label);
		if (nodeToRemove == null) {
			return;
		}
		for (Node node : getAllNodes()) {
			node.getAdjacentNodes().remove(nodeToRemove);
			node.removeEdge(nodeToRemove);
		}
		nodes.remove(nodeToRemove.label);
	}

	/**
	 * Deletes an edge from the graph.
	 * 
	 * @param fromLabel is the label of the first node on the edge to delete
	 * @param toLabel   is the label of the second node on the edge to delete
	 */

	public void removeEdge(String fromLabel, String toLabel) {
		Node from = nodes.get(fromLabel);
		Node to = nodes.get(toLabel);
		if (from == null || to == null) {
			return;
		}
		from.removeEdge(to);
	}

	/**
	 * Finds is two nodes are adjacent.
	 * 
	 * @param fromLabel is the label of the first node
	 * @param toLabel   is the label of the second node
	 * 
	 * @return {@code true} if the nodes are adjacent, or {@code false} if the nodes
	 *         are not adjacent
	 */

	public boolean areAdjacent(String fromLabel, String toLabel) {
		Node from = nodes.get(fromLabel);
		Node to = nodes.get(toLabel);
		return from.getAdjacentNodes().contains(to);
	}

	/**
	 * TO STRING (PRINTING THE GRAPH)
	 */

	/**
	 * Prints into a string the adjacency list of the graph.
	 * 
	 * @return a string which contains the adjacency list of the graph
	 */

	@Override
	public String toString() {
		StringBuffer toPrint = new StringBuffer();
		for (Node node : getAllNodes()) {
			toPrint.append(node.label + " -> " + node.getAdjacentNodes() + "\n");
		}
		return toPrint.toString();
	}

	/**
	 * For each node of the graph, prints a list of edges with their weights.
	 */

	public void printEdges() {
		for (Node node : getAllNodes()) {
			System.out.println(node.label + " -> " + node.getInsidentEdges());
		}
	}

	/**
	 * TRAVERSALS
	 */

	/**
	 * Traverses the graph in a depth-first-search (DFS) manner. Does it
	 * recursively.
	 * 
	 * In this traversal, each node is named only once when visited for the first
	 * time.
	 * 
	 * @param start is the label of the starting node
	 * 
	 * @return list of labels of the nodes
	 */

	public List<String> traverseDFSRec(String start) {
		List<String> traversal = new ArrayList<>();
		Set<Node> visited = new HashSet<Node>();
		Node startNode = nodes.get(start);

		if (startNode == null) {
			return null;
		}

		traverseDFSRec(startNode, visited, traversal);
		return traversal;
	}

	/**
	 * Recursively traverses the unvisited part of the graph in a depth-first-search
	 * (DFS) manner starting from the startNode. Writes the traversed nodes into the
	 * list traversal.
	 * 
	 * In this traversal, each node is named only once when visited for the first
	 * time.
	 * 
	 * @param startNode is the label of the starting node
	 * @param visited   is the set of visited (traversed) nodes
	 * @param traversal is the list of labels of traversed nodes
	 */

	private void traverseDFSRec(Node startNode, Set<Node> visited, List<String> traversal) {
		traversal.add(startNode.label);
		visited.add(startNode);
		for (Node node : startNode.getAdjacentNodes()) {
			if (!visited.contains(node)) {
				traverseDFSRec(node, visited, traversal);
			}
		}
	}

	/**
	 * Traverses the graph in a depth-first-search (DFS) manner. Does it
	 * recursively.
	 * 
	 * In this traversal, the full traversal path is recorded. It means that some
	 * nodes will be mentioned several times in the resulting list.
	 * 
	 * @param start is the label of the starting node
	 * 
	 * @return list of labels of the nodes
	 */

	public List<String> traverseDFSFullPathRec(String start) {
		List<String> traversal = new ArrayList<>();
		Set<Node> visited = new HashSet<Node>();
		Node startNode = nodes.get(start);

		if (startNode == null) {
			return null;
		}

		traverseDFSFullPathRec(startNode, visited, traversal);
		return traversal;
	}

	/**
	 * Recursively traverses the unvisited part of the graph in a depth-first-search
	 * (DFS) manner starting from the startNode. Writes the traversed nodes into the
	 * list traversal.
	 * 
	 * In this traversal, the full traversal path is recorded. It means that some
	 * nodes will be mentioned several times in the resulting list.
	 * 
	 * @param startNode is the label of the starting node
	 * @param visited   is the set of visited (traversed) nodes
	 * @param traversal is the list of labels of traversed nodes
	 */

	private void traverseDFSFullPathRec(Node startNode, Set<Node> visited, List<String> traversal) {
		traversal.add(startNode.label);
		visited.add(startNode);
		for (Node node : startNode.getAdjacentNodes()) {
			if (!visited.contains(node)) {
				traverseDFSRec(node, visited, traversal);
				traversal.add(startNode.label);
			}
		}
	}

	/**
	 * Traverses the graph in a depth-first-search (DFS) manner. Does it
	 * iteratively.
	 * 
	 * In this traversal, each node is named only once when visited for the first
	 * time.
	 * 
	 * @param start is the label of the starting node
	 * 
	 * @return list of labels of the nodes
	 */

	public List<String> traverseDFS(String start) {
		Node startNode = nodes.get(start);
		if (startNode == null) {
			return null;
		}
		List<String> traversal = new ArrayList<>();
		Set<Node> visited = new HashSet<>();
		Stack<Node> stack = new Stack<>();
		stack.push(startNode);

		while (!stack.isEmpty()) {
			Node current = stack.pop();
			if (visited.contains(current)) {
				continue;
			}
			visited.add(current);
			traversal.add(current.label);

			for (Node node : current.getAdjacentNodes()) {
				if (!visited.contains(node)) {
					stack.push(node);
				}
			}
		}
		return traversal;
	}

	private boolean neighborhoodIsVisited(Node node, Set<Node> visited) {
		for (Node neighbor : node.getAdjacentNodes()) {
			if (!visited.contains(neighbor)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Traverses the graph in a depth-first-search (DFS) manner. Does it
	 * iteratively.
	 * 
	 * In this traversal, the full traversal path is recorded. It means that some
	 * nodes will be mentioned several times in the resulting list.
	 * 
	 * @param start is the label of the starting node
	 * 
	 * @return list of labels of the nodes
	 */

	public List<String> traverseDFSFullPath(String start) {
		Node startNode = nodes.get(start);
		if (startNode == null) {
			return null;
		}
		List<String> traversal = new ArrayList<>();
		Set<Node> visited = new HashSet<>();
		Stack<Node> stack = new Stack<>();
		stack.push(startNode);

		while (!stack.isEmpty()) {
			Node current = stack.peek();
			traversal.add(current.label);
			visited.add(current);
			if (neighborhoodIsVisited(current, visited)) {
				stack.pop();
				continue;
			}
			for (Node node : current.getAdjacentNodes()) {
				if (!visited.contains(node)) {
					stack.push(node);
				}
			}
		}
		return traversal;
	}

	/**
	 * Traverses the graph in a breadth-first-search (BFS) manner. Does it
	 * iteratively.
	 * 
	 * @param start is the label of the starting node
	 * 
	 * @return list of labels of the nodes
	 */

	public List<String> traverseBFS(String start) {
		Node startNode = nodes.get(start);
		if (startNode == null) {
			return null;
		}
		List<String> traversal = new ArrayList<>();
		Set<Node> visited = new HashSet<>();
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(startNode);

		while (!queue.isEmpty()) {
			Node current = queue.remove();
			if (visited.contains(current)) {
				continue;
			}
			visited.add(current);
			traversal.add(current.label);

			for (Node node : current.getAdjacentNodes()) {
				if (!visited.contains(node)) {
					queue.add(node);
				}
			}
		}
		return traversal;
	}
}
