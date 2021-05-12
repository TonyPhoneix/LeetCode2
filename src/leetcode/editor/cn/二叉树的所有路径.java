//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索 
// 👍 495 👎 0

package leetcode.editor.cn;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * [257] 二叉树的所有路径 </br>
 *
 * @see <a href="https://leetcode-cn.com/problems/binary-tree-paths/">二叉树的所有路径</a>
 */
public class 二叉树的所有路径 {

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

        List<List<Integer>> res;

        public List<String> binaryTreePaths(TreeNode root) {
            res = new ArrayList<>();
            dp(root, new LinkedList<>());
            return res.stream().map(list -> list.stream().map(Object::toString)
                    .collect(Collectors.joining("->"))).collect(Collectors.toList());
        }

        public void dp(TreeNode root, LinkedList<Integer> path) {
            if (root == null) {
                return;
            }
            path.add(root.val);
            if (root.left == null && root.right == null) {
                //叶子节点
                res.add(new ArrayList<>(path));
            }
            dp(root.left, path);
            dp(root.right, path);
            path.removeLast();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 二叉树的所有路径().new Solution();
    }

}