package 剑指offer;

public class 链表中倒数第K个节点 {
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            if (cur == null) {
                return null;
            }
            cur = cur.next;
        }
        while (cur != null) {
            cur = cur.next;
            head = head.next;
        }
        return head;
    }
}
