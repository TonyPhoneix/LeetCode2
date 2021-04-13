package 排序;

import 链表.ListNode;

import java.util.List;

/**
 * Created by Tony on 2017/5/16.
 */
public class 插入排序链表 {
    public static ListNode insertionSortList(ListNode head) {
        //定义一个伪头
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        //当前要操作的节点
        ListNode cur;
        for (cur = head; cur != null; ) {
            //找到我们要插入的节点
            ListNode pos = findInsertNode(dummy, cur.val);
            //先记录一下下一个节点
            ListNode tmp = cur.next;
            cur.next = pos.next;
            pos.next = cur;
            cur = tmp;
        }
        return dummy.next;
    }

    private static ListNode findInsertNode(ListNode dummy, int val) {
        ListNode cur = dummy;
        ListNode pre = null;
        //开始循环找到 我们要插入的节点，循环终止时cur的前面一个节点就是我们要插入的节点。
        for (; cur != null && cur.val <= val; pre = cur, cur = cur.next) ;
        return pre;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(-2147483647);
        node.next = new ListNode(-2147483648);
        ListNode listNode = insertionSortList(node);
    }
}
