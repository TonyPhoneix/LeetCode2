//路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。
// 该路径 至少包含一个 节点，且不一定经过根节点。
//
// 路径和 是路径中各节点值的总和。 
//
// 给你一个二叉树的根节点 root ，返回其 最大路径和 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3]
//输出：6
//解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6 
//
// 示例 2： 
//
// 
//输入：root = [-10,9,20,null,null,15,7]
//输出：42
//解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围是 [1, 3 * 104] 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 1041 👎 0

package leetcode.editor.cn;

import common.TreeNode;
import common.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * [124] 二叉树中的最大路径和 </br>
 *
 * @see <a href="https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/">二叉树中的最大路径和</a>
 */
public class 二叉树中的最大路径和 {

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

        private List<Integer> res;

        private Integer max = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            dp2(root);
            System.out.println(res);
            return max;
        }

        public List<Integer> maxPath(TreeNode root) {
            dp2(root);
            return res;
        }

        /**
         * 假设路径走过当前node的最大路径和
         * 状态：dp(node) 路径走过当前节点的最大路径
         * <p>
         * 要么是左右子树都是最大路径，加上node成为最终的最大路径
         * 要么是一条左右子树中最大的一条加上当前node，成为最大路径，然后向上回溯。
         * <p>
         * 当前节点作为最大路径和的节点返回的最大值。
         * <p>
         */
        public int dp(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int left = Math.max(dp(node.left), 0);
            int right = Math.max(dp(node.right), 0);
            //这里我们假设当前节点是连接左右子树的根节点，然后计算一下最大值。
            int max = left + right + node.val;
            this.max = Math.max(max, this.max);
            //返回左右子树中最大值 + 当前值。
            return Math.max(left, right) + node.val;
        }

        public Node dp2(TreeNode node) {
            if (node == null) {
                return new Node(0, new ArrayList<>());
            }
            Node l = dp2(node.left);
            int left = Math.max(l.res, 0);
            Node r = dp2(node.right);
            int right = Math.max(r.res, 0);
            //这里我们假设当前节点是连接左右子树的根节点，然后计算一下最大值。
            int max = left + right + node.val;
            if (max > this.max) {
                this.max = max;
                List<Integer> list = new ArrayList<>();
                if (l.res > 0) {
                    list.addAll(l.path);
                }
                list.add(node.val);
                if (r.res > 0) {
                    list.addAll(r.path);
                }
                this.res = list;
            }
            //返回左右子树中最大值 + 当前值。
            if (left > right) {
                l.path.add(node.val);
                return new Node(left + node.val, l.path);
            } else {
                r.path.add(node.val);
                return new Node(right + node.val, r.path);
            }
        }

        class Node {
            int res;
            List<Integer> path;

            public Node(int res, List<Integer> path) {
                this.res = res;
                this.path = path;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 二叉树中的最大路径和().new Solution();
        TreeNode root = Utils.toTree("-10,9,20,null,null,15,7");
//        TreeNode root = Utils.toTree("2,-1");
        Utils.show(root);
//        int dp = solution.maxPathSum(root);
        List<Integer> path = solution.maxPath(root);
//        System.out.println(dp);
        System.out.println(path);
    }

}