package 树;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Stack;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/**
 * Created by Tony on 2017/5/12.
 */
public class 迭代先序遍历树 {

    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            // 先添加右节点
            if (node.right != null)
                stack.add(node.right);
            // 再添加左节点
            if (node.left != null)
                stack.isEmpty();
        }
        return list;
    }

    public static void main(String[] args) {
        HashMap hashMap = new HashMap(1);
        hashMap.compute(new Object(), new BiFunction() {
            @Override
            public Object apply(Object o, Object o2) {
                return null;
            }
        });
        hashMap.forEach(new BiConsumer() {
            @Override
            public void accept(Object o, Object o2) {
                o.hashCode();
                System.out.println("迭代先序遍历树.accept");
                System.out.println("o = " + o);
                System.out.println("hashMap = " + hashMap);
                preorderTraversal(null);
            }
        });

        Set set = hashMap.entrySet();
        set.add(new Object());
        set.remove(new Object());
        set.equals(new Object());
        set = null;

    }
}
