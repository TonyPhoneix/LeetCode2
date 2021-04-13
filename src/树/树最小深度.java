package 树;

/**
 * Created by Tony on 2017/5/12.
 */
public class 树最小深度 {
    public static int run(TreeNode root) {
        //若为空树返回0
        if (root == null) {
            return 0;
        }
        // 只有一个节点
        if (root.left == null && root.right == null)
            return 1;
        //若左子树为空，则返回右子树的最小深度+1
        if (root.left == null)
            return run(root.right) + 1;
        //若右子树为空，则返回左子树的最小深度+1
        if (root.right == null)
            return run(root.left) + 1;
        //若左右子树均不为空，则取左、右子树最小深度的较小值+1
        int left = run(root.left);
        int right = run(root.right);
        return Math.min(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
//        node.right = new TreeNode(3);
//        node.right.right = new TreeNode(1);
        int result = run(node);
        System.out.println(result);
    }
}
