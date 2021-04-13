package 剑指offer;

public class 删除链表中重复的节点 {
    public ListNode deleteDuplication(ListNode pHead){
        if (pHead == null) {
            return null;
        }
        ListNode head = new ListNode(-1);
        ListNode pre = head;
        ListNode cur = pHead;
        head.next = pHead;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                //寻找后面不同的节点
                while (cur != null && cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head.next;
    }
}
