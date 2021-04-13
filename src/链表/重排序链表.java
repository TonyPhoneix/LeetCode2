package 链表;

import java.util.List;

/**
 * 给出单链表L：L0→L1→...→Ln-1→Ln，
 * 重新排序为：L0→Ln→L1→Ln-1→L2→Ln-2→...
 * 您必须在原地就位而不改变节点的值。
 * 例如，
 * 给定{1,2,3,4}，将其重新排序为1{,4,2,3}。
 * Created by Tony on 2017/5/17.
 */
public class 重排序链表 {
    /**
     * 可以找到中间节点，断开，把后半截单链表reverse一下，再合并两个单链表。
     * @param head
     */
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        //找到链表中间的点
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //断开链
        pre.next = null;
        //反转后面的链表
//        System.out.println(slow.val);
        slow = reverse(slow);
//        System.out.println(slow.val + slow.next.val);
        //合并两个链表
        ListNode cur = head;
        while (cur.next != null) {
            //保存下一个节点
            ListNode tmp = cur.next;
            cur.next = slow;
            slow = slow.next;
            cur.next.next = tmp;
            cur = tmp;
        }
        //可能slow并没有遍历玩，cur就遍历完了，所以要把slow后面的链表加上。
        cur.next = slow;
    }

    private static ListNode reverse(ListNode head) {
        //不要粗心大意，要是出了bug调试一下
        if (head == null && head.next==null) {
            return head;
        }

        ListNode cur = head;
        ListNode pre = null;
        ListNode next;
        while (cur!= null) {
            //记录下一个节点
            next = cur.next;
            //将当前节点指向前驱节点
            cur.next = pre;
            //更新前驱节点
            pre = cur;
            //移动到下一个节点
            cur = next;
        }
        //当cur为空跳出循环时，pre就是反转后的头节点。
        return pre;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        reorderList(node);
    }
}
