package 链表;

/**
 * 给定一个链表，返回循环开始的节点。 如果没有循环，returnnull。
 * 跟进：
 * 你可以解决它，而不用额外的空间吗？
 * <p>
 * Created by Tony on 2017/5/17.
 */
public class 找出环形链表入口节点 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                //移动到头部
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                break;
            }
        }
        return slow;
    }
}
