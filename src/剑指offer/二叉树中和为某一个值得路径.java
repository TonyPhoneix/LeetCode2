package 剑指offer;

import java.util.ArrayList;

public class 二叉树中和为某一个值得路径 {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return res;
        }
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.right == null && root.left == null) {
            res.add(new ArrayList<>(list));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size() - 1);
        return res;
    }
}
