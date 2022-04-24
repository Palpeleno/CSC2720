package labs.lab13;

import java.util.LinkedList;

public class UndirectedGraphOnDistanceMatrix implements Comparable<UndirectedGraphOnDistanceMatrix> {

    NodeWeighted source;
    NodeWeighted destination;
    double weight;

    UndirectedGraphOnDistanceMatrix(NodeWeighted s, NodeWeighted d, double w) {
                source = s;
                destination = d;
                weight = w;
            }

    public String toString() {
        return String.format("(%s -> %s, %f)", source.name, destination.name, weight);
    }

    // We need this method if we want to use PriorityQueues instead of LinkedLists
    // to store our edges, the benefits are discussed later, we'll be using
    // LinkedLists
    // to make things as simple as possible
    public int compareTo(UndirectedGraphOnDistanceMatrix otherEdge) {

        // We can't simply use return (int)(this.weight - otherEdge.weight) because
        // this sometimes gives false results
        if (this.weight > otherEdge.weight) {
            return 1;
        } else
            return -1;
    }

    public class NodeWeighted {
        // The int n and String name are just arbitrary attributes
        // we've chosen for our nodes these attributes can of course
        // be whatever you need
        int n;
        String name;
        private boolean visited;
        LinkedList<UndirectedGraphOnDistanceMatrix> edges;

        NodeWeighted(int n, String name) {
            this.n = n;
            this.name = name;
            visited = false;
            edges = new LinkedList<>();
        }

        boolean isVisited() {
            return visited;
        }

        void visit() {
            visited = true;
        }

        void unvisit() {
            visited = false;
        }
    }

}
