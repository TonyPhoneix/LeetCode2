//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 1054 👎 0

package leetcode.editor.cn;

import common.TreeNode;

import java.util.Stack;

/**
 * [98] 验证二叉搜索树 </br>
 *
 * @see <a href="https://leetcode-cn.com/problems/validate-binary-search-tree/">验证二叉搜索树</a>
 */
public class 验证二叉搜索树 {

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        //   5  递归方式
        // 4   6
        //n n 3  7
        //思路：root大于左子树的所有值，root小于右边的所有值
        public boolean isValidBST2(TreeNode root) {
            return dp(root, Long.MIN_VALUE, Long.MIN_VALUE);
        }

        /**
         * 思路，当前节点一定大于左边所有节点和小于右边的所有节点。
         *
         * @param root
         * @param leftHigh 左边最大 初始MIN
         * @param rightLow 右边最小 初始MAX
         * @return
         */
        public boolean dp(TreeNode root, long leftHigh, long rightLow) {
            if (root == null) {
                return true;
            }
            if (root.val <= leftHigh || root.val >= rightLow) {
                //2 true
                //1 leftHigh = MIN, right = 2
                //3 left = 2, right = MAX
                return false;
            }
            //递归子树
            return dp(root.left, leftHigh, root.val) && dp(root.right, root.val, rightLow);
        }

        public boolean isValidBST(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            long pre = Long.MIN_VALUE;
            while (cur != null || !stack.isEmpty()) {
                if (cur != null) {
                    //如果不为空，则压栈，指针指向左节点，循环这个过程，左树就会全部压栈
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    //如果未空，说明走到头了，那就要出栈并打印，然后去右子树看看。
                    var pop = stack.pop();
                    if (pop.val <= pre) {
                        return false;
                    }
                    pre = pop.val;
                    cur = pop.right;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 验证二叉搜索树().new Solution();
        TreeNode treeNode = new TreeNode(0);
//        treeNode.left = new TreeNode(1);
//        treeNode.right = new TreeNode(3);
        boolean validBST = solution.isValidBST(treeNode);
    }

}