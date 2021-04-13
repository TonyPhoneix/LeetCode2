package 剑指offer;

public class 翻转链表 {
    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode next;
        ListNode pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
