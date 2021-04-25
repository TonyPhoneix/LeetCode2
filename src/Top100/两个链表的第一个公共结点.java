package Top100;
import common.*;


/**
 * 输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 * https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46?tpId=190&tqId=36002&rp=1&ru=%2Fta%2Fjob-code-high-rd&qru=%2Fta%2Fjob-code-high-rd%2Fquestion-ranking&tab=answerKey
 */
public class 两个链表的第一个公共结点 {

    /**
     * 思路：
     * 一长一短，让长的先走，然后一块出发，head1=head2,就是公共的节点
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int p1 = length(pHead1);
        int p2 = length(pHead2);
        if (p1 < p2) {
            //让pHead2先走
            pHead2 = go(pHead2, p2 - p1);
        } else {
            //让pHead1先走
            pHead1 = go(pHead1, p1 - p2);
        }

        while (pHead1 != pHead2) {
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        if (pHead1 != null) {
            return pHead1;
        }
        return null;
    }

    private ListNode go(ListNode node, int step) {
        int i = 0;
        while (i < step) {
            node = node.next;
            i++;
        }
        return node;

    }

    public int length(ListNode node) {
        int i = 0;
        while (node != null) {
            i++;
            node = node.next;
        }
        return i;
    }

}
