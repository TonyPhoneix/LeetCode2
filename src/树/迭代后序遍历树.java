package 树;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Tony on 2017/5/12.
 */
public class 迭代后序遍历树 {

    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> reverse = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            reverse.push(node);
            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);
        }

        while (!reverse.isEmpty()) {
            list.add(reverse.pop().val);
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
