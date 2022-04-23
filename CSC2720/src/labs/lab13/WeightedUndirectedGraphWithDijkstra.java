package labs.lab13;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class WeightedUndirectedGraphWithDijkstra {
	private Map<String, Node> nodes = new HashMap<>();

	private class Node {
		private String label;
		private List<Node> adjacentNodes = new ArrayList<>();
		private List<Edge> incidentEdges = new ArrayList<>();

		public Node(String label) {
			this.label = label;
		}

		public void addEdge(Node theOther, int weight) {
			if (!adjacentNodes.contains(theOther)) {
				adjacentNodes.add(theOther);
				incidentEdges.add(new Edge(this, theOther, weight));
			}
		}

		public void removeEdge(Node theOther) {
			Edge edgeToRemove = null;
			for (Edge edge : incidentEdges) {
				if (edge.endOne == this && edge.endTwo == theOther || edge.endTwo == this && edge.endOne == theOther) {
					edgeToRemove = edge;
					break;
				}
			}
			adjacentNodes.remove(theOther);
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
		private Node endOne;
		private Node endTwo;
		private int weight;

		public Edge(Node endOne, Node endTwo, int weight) {
			this.endOne = endOne;
			this.endTwo = endTwo;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "{" + endOne + "," + endTwo + ":w=" + weight + "}";
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
	 * @param one    is the label of the first node on the edge to add
	 * @param two    is the label of the second node on the edge to add
	 * @param weight is the weight of the edge to add
	 */

	public void addEdge(String one, String two, int weight) {
		Node nodeOne = nodes.get(one);
		Node nodeTwo = nodes.get(two);
		if (nodeOne == null || nodeTwo == null) {
			throw new IllegalArgumentException("No such node exists!");
		}
		nodeOne.addEdge(nodeTwo, weight);
		nodeTwo.addEdge(nodeOne, weight);
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
		nodes.remove(label);
	}

	/**
	 * Deletes an edge from the graph.
	 * 
	 * @param one is the label of the first node on the edge to delete
	 * @param two is the label of the second node on the edge to delete
	 */

	public void removeEdge(String one, String two) {
		Node nodeOne = nodes.get(one);
		Node nodeTwo = nodes.get(two);
		if (nodeOne == null || nodeTwo == null) {
			return;
		}
		nodeOne.removeEdge(nodeTwo);
		nodeTwo.removeEdge(nodeOne);
	}

	/**
	 * Finds is two nodes are adjacent.
	 * 
	 * @param one is the label of the first node
	 * @param two is the label of the second node
	 * 
	 * @return {@code true} if the nodes are adjacent, or {@code false} if the nodes
	 *         are not adjacent
	 */

	public boolean areAdjacent(String one, String two) {
		Node nodeOne = nodes.get(one);
		Node nodeTwo = nodes.get(two);
		return nodeOne.getAdjacentNodes().contains(nodeTwo);
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

	/*
	 * Dijkstra's algorithm: Version 1
	 * 
	 * Uses a mapping Map<String, Integer> to add a new field ``weight'' to a node.
	 * This weight is the shortest distance from the node ``from'' to the current node.
	 * 
	 * Returns as an output
	 * 		-> the lengths of the shortest path
	 * Returns as an input parameter ``path'' 
	 * 		-> the shortest path itself
	 */


	/**
	 * Finds the shortest path between two nodes and its length. Implements the
	 * Dijkstra's algorithm, thus, no cycles with negative length are allowed in the
	 * graph.
	 * 
	 * @param from is the label of the node from which the path begins
	 * @param to   is the label of the node where the path ends
	 * @param path returns the shortest path from the node ``from'' to the node ``to''
	 * 
	 * @return the length of the shortest path between the node labeled ``from'' and
	 *         the node labeled ``to''
	 */

	public int getShortestDistance(String from, String to, List<String> path) {
		Node start = nodes.get(from);
		Node finish = nodes.get(to);
		if (start == null || finish == null) {
			throw new IllegalArgumentException();
		}

		Map<Node, Integer> distances = new HashMap<>();
		for (Node node : getAllNodes()) {
			distances.put(node, Integer.MAX_VALUE);
		}
		distances.put(start, 0);

		Set<Node> visited = new HashSet<>();
		Map<Node, Node> previousNodes = new HashMap<>();

		Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(node -> distances.get(node)));
		queue.add(start);

		while (!queue.isEmpty()) {
			Node current = queue.remove();
			if (visited.contains(current)) {
				continue;
			}
			visited.add(current);

			for (Edge edge : current.getInsidentEdges()) {
				Node neighbor = edge.endTwo;
				if (visited.contains(neighbor)) {
					continue;
				}
				int newDistance = distances.get(current) + edge.weight;
				int oldDistance = distances.get(neighbor);
				if (newDistance < oldDistance) {
					distances.put(neighbor, newDistance);
					queue.add(neighbor);
					previousNodes.put(neighbor, current);
				}
			}
		}

		Stack<Node> reversedPath = new Stack<>();
		Node current = finish;
		reversedPath.push(current);

		while (previousNodes.get(current) != null) {
			current = previousNodes.get(current);
			reversedPath.push(current);
		}

		while (!reversedPath.isEmpty()) {
			path.add(reversedPath.pop().label);
		}

		return distances.get(finish);
	}

	/*
	 * Dijkstra's algorithm: Version 2
	 * 
	 * Uses a new class WeightedNode to add a new field ``weight'' to a node.
	 * This weight is the shortest distance from the node ``from'' to the current node.
	 * 
	 * Returns as an output
	 * 		-> the lengths of the shortest path
	 * Returns as an input parameter ``path'' 
	 * 		-> the shortest path itself
	 */

	private class WeightedNode {
		private Node node;
		private int weight;

		public WeightedNode(Node node, int weight) {
			this.node = node;
			this.weight = weight;
		}
	}

	/**
	 * Finds the shortest path between two nodes and its length. Implements the
	 * Dijkstra's algorithm, thus, no cycles with negative length are allowed in the
	 * graph.
	 * 
	 * @param from is the label of the node from which the path begins
	 * @param to   is the label of the node where the path ends
	 * @param path returns the shortest path from the node ``from'' to the node ``to''
	 * 
	 * @return the length of the shortest path between the node labeled ``from'' and
	 *         the node labeled ``to''
	 */

	public int getShortestDistanceVersionWithWeightedNodes(String from, String to, List<String> path) {
		Node start = nodes.get(from);
		Node finish = nodes.get(to);
		if (start == null || finish == null) {
			throw new IllegalArgumentException();
		}

		Map<Node, WeightedNode> weighted = new HashMap<>();
		for (Node node : getAllNodes()) {
			weighted.put(node, new WeightedNode(node, Integer.MAX_VALUE));
		}
		weighted.get(start).weight = 0;

		Set<Node> visited = new HashSet<>();
		Map<Node, Node> previousNodes = new HashMap<>();

		Queue<WeightedNode> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
		queue.add(weighted.get(start));

		while (!queue.isEmpty()) {
			WeightedNode current = queue.remove();
			if (visited.contains(current.node)) {
				continue;
			}
			visited.add(current.node);

			for (Edge edge : current.node.getInsidentEdges()) {
				Node neighbor = edge.endTwo;
				if (visited.contains(neighbor)) {
					continue;
				}
				WeightedNode weightedNeighbor = weighted.get(neighbor);
				int newDistance = current.weight + edge.weight;
				int oldDistance = weightedNeighbor.weight;
				if (newDistance < oldDistance) {
					weightedNeighbor.weight = newDistance;
					queue.add(weightedNeighbor);
					previousNodes.put(neighbor, current.node);
				}
			}
		}

		Stack<Node> reversedPath = new Stack<>();
		Node current = finish;
		reversedPath.push(current);

		while (previousNodes.get(current) != null) {
			current = previousNodes.get(current);
			reversedPath.push(current);
		}

		while (!reversedPath.isEmpty()) {
			path.add(reversedPath.pop().label);
		}

		return weighted.get(finish).weight;
	}

	/*
	 * Dijkstra's algorithm: Version 3
	 * 
	 * Uses a mapping Map<String, Integer> to add a new field ``weight'' to a node.
	 * This weight is the known so far shortest distance 
	 * from the node ``from'' to the current node.
	 * 
	 * Returns as an output 
	 * 		-> the distances from the node ``from'' to all other nodes.
	 * Returns as an input parameter ``previousNodes'' 
	 * 		-> the mapping between a node and its predecessor
	 * 		   on the path from the node ``from'' to this node.
	 */

	/**
	 * Finds the shortest path between two nodes and its length. Implements the
	 * Dijkstra's algorithm, thus, no cycles with negative length are allowed in the
	 * graph.
	 * 
	 * @param from          is the label of the node from which the path starts
	 * @param previousNodes returns the mapping between a node and its predecessor
	 *                      on the way from the node ``from'' to this node 
	 * 
	 * @return the mapping between a node and the shortest distance to this node
	 *         from the node ``from''
	 */

	public Map<String, Integer> getShortestDistances(String from, Map<String, String> previousNodes) {
		Node start = nodes.get(from);
		if (start == null) {
			throw new IllegalArgumentException();
		}
		Map<String, Integer> distances = new HashMap<>();
		for (Node node : getAllNodes()) {
			distances.put(node.label, Integer.MAX_VALUE);
		}
		distances.put(start.label, 0);

		Set<Node> visited = new HashSet<>();
		Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(node -> distances.get(node.label)));
		queue.add(start);

		while (!queue.isEmpty()) {
			Node current = queue.remove();
			if (visited.contains(current)) {
				continue;
			}
			visited.add(current);

			for (Edge edge : current.getInsidentEdges()) {
				Node neighbor = edge.endTwo;
				if (visited.contains(neighbor)) {
					continue;
				}
				int newDistance = distances.get(current.label) + edge.weight;
				int oldDistance = distances.get(neighbor.label);
				if (newDistance < oldDistance) {
					distances.put(neighbor.label, newDistance);
					queue.add(neighbor);
					previousNodes.put(neighbor.label, current.label);
				}
			}
		}
		return distances;
	}

}
