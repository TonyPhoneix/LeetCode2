package newcoderTop100;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Tony on 2017/5/12.
 */
public class 树的迭代遍历 {

    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        //前序遍历的思路，申请一个栈， 栈的特性是先进先出，前序遍历是先头右左，
        //压栈顺序 头右左，遍历顺序 头左右
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            list.add(pop.val);
            if (pop.right != null) {
                //先插入右
                stack.push(pop.right);
            }
            if (pop.left != null) {
                //再插入左
                stack.push(pop.left);
            }
        }
        return list;
    }

    /**
     * 中序遍历
     * 从小到大
     *
     * @param root
     * @return
     */
    public static ArrayList<Integer> midOrderTraversal(TreeNode root) {
        //中序遍历，right，head，left
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                //如果不为空，则压栈，指针指向左节点，循环这个过程，左树就会全部压栈
                stack.push(cur);
                cur = cur.left;
            } else {
                //如果未空，说明走到头了，那就要出栈并打印，然后去右子树看看。
                var pop = stack.pop();
                list.add(pop.val);
                cur = pop.right;
            }
        }
        return list;
    }

    public static ArrayList<Integer> postorderTraversal(TreeNode root) {
        //思路，和前序模式一样，压栈顺序调整为头左右，出栈顺序头右左， 再逆序变成 左右头
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> reverse = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            reverse.push(node);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        while (!reverse.isEmpty()) {
            list.add(reverse.pop().val);
        }
        return list;
    }

    /**
     * 树的层序遍历
     *
     * @param root
     * @return
     */
    public static ArrayList<Integer> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            var node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        /*
                5
               / \
              4   7
                 / \
                6   8
         */
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        var treeNode = new TreeNode(7);
        node.right = treeNode;
        treeNode.left = new TreeNode(6);
        treeNode.right = new TreeNode(8);
//        var integers = preorderTraversal(node);
//        var integers = midOrderTraversal(node);
//        var integers = postorderTraversal(node);
        var integers = levelOrder(node);
        System.out.println(integers);
    }
}
