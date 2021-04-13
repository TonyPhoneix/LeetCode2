package newcoder;

/**
 * 给定一个链表，删除链表的倒数第 nn 个节点并返回链表的头指针
 * 例如，
 * 给出的链表为: 1\to 2\to 3\to 4\to 51→2→3→4→5, n= 2n=2.
 * 删除了链表的倒数第 nn 个节点之后,链表变为1\to 2\to 3\to 51→2→3→5.
 * <p>
 * 备注：
 * 题目保证 nn 一定是有效的
 * 请给出请给出时间复杂度为\ O(n) O(n) 的算法
 */
public class 删除链表的倒数第n个节点 {

    /**
     * {1,2},2
     *
     * 用快慢指针，先让快指针走n步，然后slow，fast一起走，需要删除的节点就是slow.next，让其指向slow.next.next即删除。
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write code here
        //快慢指针
        int i = 0;
        ListNode ln = new ListNode(0);
        ln.next = head;
        ListNode fast = ln;
        ListNode slow = ln;
        while (i < n && fast != null) {
            fast = fast.next;
            i++;
        }
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return ln.next;
    }
}
