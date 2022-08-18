package orderGenerators;

import java.util.ArrayList;

public interface OrderGenerator {

    public ArrayList<Integer> generateOrder(int vertices, ArrayList<Integer> edges[], int[] in_degrees);

}
