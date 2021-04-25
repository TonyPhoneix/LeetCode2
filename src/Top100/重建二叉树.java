package Top100;
import common.*;

public class 重建二叉树 {

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     * <p>
     * 输入：[1,2,3,4,5,6,7],[3,2,4,1,6,5,7]
     * 输出：{1,2,5,3,4,6,7}
     *
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return rebuild(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public TreeNode rebuild(int[] pre, int preStart, int endStart, int[] in, int inStart, int inEnd) {
        //base case
        if (inStart > inEnd || preStart > endStart) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        //然后拆分in数组
        int i = inStart;
        for (; i <= inEnd; i++) {
            if (in[i] == pre[preStart]) {
                //以i为边界，开始拆数组,左边是左子树，右边是右子树
                root.left = rebuild(pre, preStart + 1, endStart, in, inStart, i - 1);
                root.right = rebuild(pre, preStart + 2, endStart, in, i + 1, endStart);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        重建二叉树 c = new 重建二叉树();
        var treeNode = c.reConstructBinaryTree(new int[]{1, 2, 3}, new int[]{2, 1, 3});
    }
}
