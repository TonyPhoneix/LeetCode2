package newcoderTop100;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 * 输入{1,2,3}
 * 返回值{3,2,1}
 */
public class 反转链表 {

    /**
     * 思路，顺序遍历，把next节点暂存，然后当前节点的指针指向上一个节点。
     *
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        //初始化pre指针，用于记录当前结点的前一个结点地址
        ListNode pre = null;
        while (head != null) {
            //初始化next指针，用于记录当前结点的下一个结点地址
            ListNode next = head.next;
            //让被当前结点与链表断开并指向前一个结点pre。
            head.next = pre;
            //pre指针指向当前结点
            pre = head;
            //head指向next(保存着原链表中head的下一个结点地址)
            head = next;
        }
        //当循环结束时,pre所指的就是反转链表的头结点
        return pre;
    }

}
