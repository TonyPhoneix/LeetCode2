package 链表;

/**
 * 给定一个链表，确定它是否有一个循环。
 * 跟进：
 * 你可以解决它，而不用额外的空间吗？
 * Created by Tony on 2017/5/17.
 */
public class 确认链表是否有环 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }


        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
