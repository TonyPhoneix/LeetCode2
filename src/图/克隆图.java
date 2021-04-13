package 图;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 克隆一个无向图。 图中的每个节点都包含其相邻列表。
 * <p>
 * OJ的无向图序列化：
 * 节点被唯一地标记。
 * 我们使用＃作为每个节点的分隔符，并且作为节点标签和节点的每个邻居的分隔符。
 * <p>
 * 例如，考虑序列化图{0,1,2＃1,2＃2,2}。
 * 该图总共有三个节点，因此包含由＃分隔开的三个部分。
 * 第一个节点被标记为0。 将node0连接到两个节点1和2。
 * 第二个节点被标记为1。 将node1连接到node2。
 * 第三个节点被标记为2。 将node2连接到node2（本身），从而形成一个自循环。
 * <p>
 * 视觉上，图形如下所示：
 *        1
 *        / \
 *       / \
 *      0 --- 2
 *           / \
 *          \ _/
 * Created by Tony on 2017/5/23.
 */
public class 克隆图 {

    /**
     * bfs做法
     * 第一种实现方法是BFS的，就是先将头节点入queue，每一次queue出列一个node，
     * 然后检查这个node的所有的neighbors，如果没visited过，就入队，并更新neighbor。
     *
     * @param node
     * @return
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }

        LinkedList<UndirectedGraphNode> list = new LinkedList<>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        map.put(node, head);
        list.add(node);
        while (!list.isEmpty()) {
            UndirectedGraphNode tmp = list.poll();
            for (UndirectedGraphNode graphNode :
                    tmp.neighbors) {
                if (!map.containsKey(graphNode)) {
                    list.add(graphNode);
                    UndirectedGraphNode newNeighbour = new UndirectedGraphNode(graphNode.label);
                    map.put(graphNode, newNeighbour);
                }

                map.get(tmp).neighbors.add(map.get(graphNode));
            }
        }
        return head;
    }

    /**
     * dfs做法
     * @param node
     * @return
     */
    public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        map.put(node, head);
        dfs(map, node);

        return node;
    }

    private void dfs(HashMap<UndirectedGraphNode, UndirectedGraphNode> map, UndirectedGraphNode node) {
        for (UndirectedGraphNode graphNode :
                node.neighbors) {
            if (!map.containsKey(graphNode)) {
                UndirectedGraphNode newNode = new UndirectedGraphNode(graphNode.label);
                map.put(graphNode, newNode);
                dfs(map, graphNode);
            }
            map.get(node).neighbors.add(graphNode);
        }
    }
}
