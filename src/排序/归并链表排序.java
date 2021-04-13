package 排序;

import 链表.ListNode;

import java.util.List;

/**
 * 使用恒定空间复杂度在O（n log n）时间内对链表进行排序。
 * Created by Tony on 2017/5/14.
 */
public class 归并链表排序 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode middle = findMid(head);
        ListNode head2 = middle.next;
        middle.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(head2);
        return sortTwoList(l1, l2);
    }

    /**
     * 合并两个链表
     * @param l1
     * @param l2
     * @return
     */
    private ListNode sortTwoList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode temp = new ListNode(-1);
        //梳理一下，这列head=temp，使两个变量指向了同一块内存区域，也就是同一块地址，那么一个变量修改了内存，
        //另一个变量也就被修改了。
        ListNode head = temp;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                //这里next 和l1指向了同一块内存
                head.next = l1;
                //但是这里l1指向了另一块内存，地址已经和原来不同了，所以不会影响head.next。
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if (l1 == null) {
            head.next = l2;
        }
        if (l2 == null) {
            head.next = l1;
        }
        return temp.next;
    }

    /**
     * 快慢指针方法找到中间的节点
     *
     * @param head
     * @return
     */
    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

        }
        return slow;
    }
}
