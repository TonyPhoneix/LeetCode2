package 剑指offer;

public class 树的子结构 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null) {
            return false;
        }
        if (root2 == null) {
            return false;
        }
        boolean isMatch = false;
        if (root1.val == root2.val) {
            isMatch = isMatch(root1, root2);
        }
        if (isMatch) {
            return true;
        }else {
            return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
        }
    }

    private boolean isMatch(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val == root2.val) {
            return isMatch(root1.left, root2.left) && isMatch(root1.right, root2.right);
        }
        return false;
    }

}
