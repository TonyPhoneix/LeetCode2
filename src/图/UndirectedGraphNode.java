package 图;

import java.util.ArrayList;

/**
 * Created by Tony on 2017/5/23.
 */
public class UndirectedGraphNode {
    int label;
    ArrayList<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
