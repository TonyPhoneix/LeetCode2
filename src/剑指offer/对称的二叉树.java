package 剑指offer;

public class 对称的二叉树 {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        TreeNode left = pRoot.left;
        TreeNode right = pRoot.right;
        return isSymmetrical(left, right);
    }

    boolean isSymmetrical(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }else if (left != null && right != null){
            if (left.val != right.val) {
                return false;
            }else {
                return isSymmetrical(left.left,right.right) && isSymmetrical(left.right,right.left);
            }
        }else {
            return false;
        }
    }
}
