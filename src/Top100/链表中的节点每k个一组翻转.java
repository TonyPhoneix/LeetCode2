package Top100;

/**
 * 题目描述
 * 将给出的链表中的节点每\ k k 个一组翻转，返回翻转后的链表
 * 如果链表中的节点数不是\ k k 的倍数，将最后剩下的节点保持原样
 * 你不能更改节点中的值，只能更改节点本身。
 * 要求空间复杂度 \ O(1) O(1)
 * 例如：
 * 给定的链表是1\to2\to3\to4\to51→2→3→4→5
 * 对于 \ k = 2 k=2, 你应该返回 2\to 1\to 4\to 3\to 52→1→4→3→5
 * 对于 \ k = 3 k=3, 你应该返回 3\to2 \to1 \to 4\to 53→2→1→4→5
 */
public class 链表中的节点每k个一组翻转 {

    /**
     * 其实这个问题很简单，局部的链表反转，但是要给出反转后的head和last，用来连接每一组链表的头和尾，
     * 遇到这个问题其实就拆解问题，一是如何连接每一组链表的头和尾，二、反转链表。
     * 问题1，提供
     *
     * @param node
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode node, int k) {
        ListNode ln = new ListNode(0);
        ListNode head = node;
        ln.next = head;
        ListNode preGroupLastNode = ln; //上一组节点的last节点
        ListNode nextGroupHeadNode = null; //下一组节点的head节点
        while (canRevert(head, k)) {
            //反转链表 TODO 要给出反转后的head和last
            ListNode cur = head;
            ListNode pre = null;
            ListNode last = head; //last记录反转后的末节点，其实就是head
            int i = 0;
            while (i < k) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
                nextGroupHeadNode = next; //记录next节点为下一组的头节点。
                i++;
            }
            //cur == null ,pre = head
            preGroupLastNode.next = pre; //上一组的last 要指向反转后的head，也就是pre
            head = nextGroupHeadNode; //head更新为下一组的头节点
            preGroupLastNode = last; // pre节点要更新为反转后的这一组的最后一个节点；
        }
        //如果遍历结束，说明剩下的节点已经无法反转，则将上一组的最后一个节点连接到head
        preGroupLastNode.next = head;
        return ln.next;
    }

    public boolean canRevert(ListNode node, int k) {
        int i = 0;
        while (node != null) {
            node = node.next;
            i++;
        }
        return i >= k;
    }
}
