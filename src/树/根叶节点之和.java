package 树;

/**
 * Created by Tony on 2017/5/12.
 */
public class 根叶节点之和 {
    /**
     * 先序遍历的思想(根左右)+数字求和(每一层都比上层和*10+当前根节点的值)
     *
     * @param root
     * @return
     */
    public static int sumNumbers(TreeNode root) {

        int sum = sumNumbers(root, 0);
        return sum;
    }

    private static int sumNumbers(TreeNode root, int sum) {
        // TODO Auto-generated method stub
        if (root == null)
            return 0;
        //计算当前节点到跟节点的值
        sum = sum * 10 + root.val;
        //如果没有子节点了，就返回当前的值
        if (root.left == null && root.right == null)
            return sum;
        //计算左右子节点相加的值。
        return sumNumbers(root.left, sum) + sumNumbers(root.right, sum);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(3);
        node.left = new TreeNode(2);
        int numbers = sumNumbers(node);
        System.out.println(numbers);
    }
}
