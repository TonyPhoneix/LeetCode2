package newcoder;

public class 链表中环的入口节点 {

    /**
     * 对于一个给定的链表，返回环的入口节点，如果没有环，返回null
     * 拓展：
     * 你能给出不利用额外空间的解法么？
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

}
