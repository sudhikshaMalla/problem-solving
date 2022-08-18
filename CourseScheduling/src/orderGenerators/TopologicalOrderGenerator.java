package orderGenerators;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class TopologicalOrderGenerator implements OrderGenerator{

    @Override
    public ArrayList<Integer> generateOrder(int vertices, ArrayList<Integer> edges[], int[] in_degrees) {
        Deque<Integer> queue = new ArrayDeque<>();
        ArrayList<Integer> orderedVertices = new ArrayList<>();

        for(int i=0; i< vertices; i++) {
            if(in_degrees[i]==0) {
                queue.offer(i);
            }
        }

        while(queue.size()!=0) {
            int vertex = queue.poll();
            orderedVertices.add(vertex);
            for(int i=0; i<edges[vertex].size(); i++) {
                int adjacent_vertex = edges[vertex].get(i);
                in_degrees[adjacent_vertex]--;
                if(in_degrees[adjacent_vertex] == 0) {
                    queue.offer(adjacent_vertex);
                }
            }
        }
        return orderedVertices;
    }
}