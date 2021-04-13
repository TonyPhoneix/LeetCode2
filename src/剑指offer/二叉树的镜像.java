package 剑指offer;

public class 二叉树的镜像 {
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        Mirror(root.left);
        Mirror(root.right);
    }
}
