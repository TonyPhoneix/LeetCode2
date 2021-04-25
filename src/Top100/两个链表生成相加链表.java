package Top100;


import common.Base;
import common.ListNode;

import java.util.Stack;

/**
 * https://www.nowcoder.com/practice/c56f6c70fb3f4849bc56e33ff2a50b6b
 * <p>
 * 假设链表中每一个节点的值都在 0 - 9 之间，那么链表整体就可以代表一个整数。
 * 给定两个这种链表，请生成代表两个整数相加值的结果链表。
 * 例如：链表 1 为 9->3->7，链表 2 为 6->3，最后生成新的结果链表为 1->0->0->0。
 * <p>
 * 输入
 * [9,3,7],[6,3]
 * 返回值
 * {1,0,0,0}
 */
public class 两个链表生成相加链表 extends Base {


    /**
     * 模拟加法
     *
     * @param head1
     * @param head2
     * @return
     */
    public ListNode addInList(ListNode head1, ListNode head2) {
        // write code here
        Stack<Integer> s1 = toStack(head1);
        Stack<Integer> s2 = toStack(head2);

        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int s1pop = s1.isEmpty() ? 0 : s1.pop();
            int s2pop = s2.isEmpty() ? 0 : s2.pop();
            int i = s1pop + s2pop + carry;
            sb.append(i % 10);
            carry = i / 10;
        }
        ListNode head = new ListNode(0);
        ListNode pre = head;
        StringBuilder reverse = sb.reverse();
        for (int i = 0; i < reverse.length(); i++) {
            ListNode cur = new ListNode(reverse.charAt(i) - '0');
            pre.next = cur;
            pre = cur;
        }
        return head.next;
    }

    private Stack<Integer> toStack(ListNode node) {
        Stack<Integer> stack = new Stack();
        while (node != null) {
            stack.add(node.val);
            node = node.next;
        }
        return stack;
    }

    public static void main(String[] args) {
        两个链表生成相加链表 c = new 两个链表生成相加链表();
        var listNode = c.addInList(c.toList("1,2,3"), c.toList("4,5,6"));
        c.printListNode(listNode);
    }
}
