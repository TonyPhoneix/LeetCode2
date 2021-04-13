package 剑指offer;

public class 二叉搜索树中第k个节点 {
    int k = 0;
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot ==null || k <= 0) {
            return null;
        }
        this.k = k;
        return getTreeNode(pRoot);
    }

    private TreeNode getTreeNode(TreeNode pRoot) {
        if (pRoot != null) {
            TreeNode treeNode = getTreeNode(pRoot.left);
            if (treeNode != null) {
                return treeNode;
            }
             
            treeNode = getTreeNode(pRoot.right);
            if (treeNode != null) {
                return treeNode;
            }
        }
        return null;
    }
}
