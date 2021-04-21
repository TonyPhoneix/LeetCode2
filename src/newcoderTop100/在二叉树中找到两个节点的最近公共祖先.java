package newcoderTop100;

/**
 * https://www.nowcoder.com/practice/e0cc33a83afe4530bcec46eba3325116
 * 给定一棵二叉树以及这棵树上的两个节点 o1 和 o2，请找到 o1 和 o2 的最近公共祖先节点。
 */
public class 在二叉树中找到两个节点的最近公共祖先 {

    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        // write code here
        return dfs(root, o1, o2).val;
    }

    /**
     * 题解
     * https://www.bilibili.com/video/BV1oA411s7xM/
     *
     * @param root
     * @param o1
     * @param o2
     * @return
     */
    public TreeNode dfs(TreeNode root, int o1, int o2) {
        // write code here
        // base case，如果当前元素的值等于o1或者o2，就返回。
        if (root == null || root.val == o1 || root.val == o2) {
            return root;
        }
        // 递归root的左子树找到符合的节点，递归root的右子树找到符合的节点
        TreeNode left = dfs(root.left, o1, o2);
        TreeNode right = dfs(root.right, o1, o2);
        //如果都找到了，说明当前root就是最近的公共节点
        if (left != null && right != null) {
            return root;
        }
        //没找到就返回存在的节点。
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;

    }
}
