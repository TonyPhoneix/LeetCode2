package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;

public class 把二叉树打印成多行 {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null) {
            return res;
        }
        LinkedList<TreeNode> nodes = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        nodes.add(pRoot);
        TreeNode last = pRoot;
        TreeNode pre = pRoot;
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            list.add(node.val);
            if (node.left != null) {
                nodes.add(node.left);
                last = node.left;
            }
            if (node.right != null) {
                nodes.add(node.right);
                last = node.right;
            }
            if (node == pre) {
                res.add(list);
                list = new ArrayList<>();
                pre = last;
            }
        }
        return res;
    }
}
