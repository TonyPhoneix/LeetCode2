//给定一个二叉树，确定它是否是一个完全二叉树。 
//
// 百度百科中对完全二叉树的定义如下： 
//
// 若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。（注：
//第 h 层可能包含 1~ 2h 个节点。） 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[1,2,3,4,5,6]
//输出：true
//解释：最后一层前的每一层都是满的（即，结点值为 {1} 和 {2,3} 的两层），且最后一层中的所有结点（{4,5,6}）都尽可能地向左。
// 
//
// 示例 2： 
//
// 
//
// 输入：[1,2,3,4,5,null,7]
//输出：false
//解释：值为 7 的结点没有尽可能靠向左侧。
// 
//
// 
//
// 提示： 
//
// 
// 树中将会有 1 到 100 个结点。 
// 
// Related Topics 树 
// 👍 123 👎 0

package leetcode.editor.cn;

import common.TreeNode;
import common.Utils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * [958] 二叉树的完全性检验 </br>
 *
 * @see <a href="https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/">二叉树的完全性检验</a>
 */
public class 二叉树的完全性检验 {

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

        /**
         * 思路：层序遍历
         *
         * @param root
         * @return
         */
        public boolean isCompleteTree(TreeNode root) {
            //关键，linkedlist可以保存null
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            TreeNode pre = root;
            while (!q.isEmpty()) {
                TreeNode poll = q.poll();
                if (pre == null && poll != null) {
                    return false;
                }
                if (poll != null) {
                    q.offer(poll.left);
                    q.offer(poll.right);
                }
                pre = poll;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 二叉树的完全性检验().new Solution();
        TreeNode root = Utils.toTree("1,1,2,3,null,null, 3,4");
        Utils.show(root);
        solution.isCompleteTree(root);
    }

}