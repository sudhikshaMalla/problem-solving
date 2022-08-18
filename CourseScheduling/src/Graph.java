import orderGenerators.OrderGenerator;

import java.util.ArrayList;

public class Graph {

    private int vertices;
    private ArrayList<Integer> edges[];
    private int[] in_degrees;
    private OrderGenerator orderGenerator;

    public Graph(int vertices, OrderGenerator orderGenerator) {
        this.vertices = vertices;
        edges = new ArrayList[vertices];
        in_degrees = new int[vertices];
        for(int i=0; i<vertices; i++) {
            edges[i] = new ArrayList<>();
        }
        this.orderGenerator = orderGenerator;
    }

    public void addEdge(int start_node, int end_node) {
        edges[start_node].add(end_node);
        in_degrees[end_node]++;
    }

    public ArrayList<Integer> getOrderedIndices() {

        return orderGenerator.generateOrder(vertices, edges, in_degrees);

    }

}