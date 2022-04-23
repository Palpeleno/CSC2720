package labs.lab13;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraphOnDistanceMatrixMain {
    public static void main(String[] args) {
        UndirectedGraphOnDistanceMatrix graph = new UndirectedGraphOnDistanceMatrix();
        for (int i = 1; i <= 6; i++) {
            graph.addNode(Integer.toString(i));
        }
        graph.addEdge("2", "1", 7);
        graph.addEdge("3", "1", 9);
        graph.addEdge("6", "1", 14);
        graph.addEdge("2", "3", 10);
        graph.addEdge("2", "4", 15);
        graph.addEdge("3", "6", 2);
        graph.addEdge("3", "4", 11);
        graph.addEdge("4", "5", 1);
        graph.addEdge("5", "6", 1);

        System.out.println(graph);
        List<String> path = new ArrayList<>();
        System.out.println(graph.getShortestDistance("1", "4", path));
        System.out.println(path);
        // // For this test, the output should look similar to:
        // [0 7 9 inf inf 14 ]
        // [7 0 10 15 inf inf]
        // [9 10 0 11 inf 2 ]
        // [inf 15 11 0 1 inf]
        // [inf inf inf 1 0 1 ]
        // [14 inf 2 inf 1 0 ]
        // 13
        // [1, 3, 6, 5, 4]
    }

}
