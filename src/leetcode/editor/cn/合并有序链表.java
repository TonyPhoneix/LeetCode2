package leetcode.editor.cn;
import common.*;

/**
 * 将两个有序的链表合并为一个新链表，要求新的链表是通过拼接两个链表的节点来生成的，且合并后新链表依然有序。
 */
public class 合并有序链表 {

    /**
     * 思路，参考merge算法
     * 1,2
     * 2,3
     * 1,2,2,3
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write code here
        ListNode head = new ListNode(0);
        ListNode pre = head;
        while (l1 != null && l2 != null) {
            ListNode cur;        //cur记录每次比较的胜出方
            if (l1.val < l2.val) {
                cur = l1;
                l1 = l1.next;
                //遍历下一个节点
            } else {
                cur = l2;
                l2 = l2.next;
            }
            //让上个节点指向胜出方
            pre.next = cur;
            //更新pre
            pre = cur;
        }
        if (l1 != null) {
            pre.next = l1;
        }
        if (l2 != null) {
            pre.next = l2;
        }
        return head.next;
    }
}
