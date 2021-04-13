package 剑指offer;

public class 平衡二叉树 {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = getDeep(root.left);
        int right = getDeep(root.right);
        if (Math.abs(left - right) > 1) {
            return false;
        }else {
            return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
        }
    }

    private int getDeep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDeep(root.left);
        int right = getDeep(root.right);
        return left > right ? left + 1 : right + 1;
    }
}
