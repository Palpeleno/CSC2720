package hw.hw4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WeightedUndirectedGraphHW4 {
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
	 * @param label  is the label of the node to add
	 */

	public void addNode(String label) {
		nodes.putIfAbsent(label, new Node(label));
	}
	
	/**
	 * Adds an edge to the graph.
	 * 
	 * @param one  is the label of the first node on the edge to add
	 * @param two  is the label of the second node on the edge to add
	 * @param weight  is the weight of the edge to add
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

    public char[] isConnected() {
        return null;
    }
}
