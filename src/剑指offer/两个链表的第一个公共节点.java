package 剑指offer;

public class 两个链表的第一个公共节点 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int p1 = getLength(pHead1);
        int p2 = getLength(pHead2);
        int i = p2 - p1;
        if (i < 0) {
            pHead1 = goHead(pHead1, Math.abs(i));
        } else {
            pHead2 = goHead(pHead2, Math.abs(i));
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

    private ListNode goHead(ListNode pHead1, int abs) {
        for (int i = 0; i < abs; i++) {
            pHead1 = pHead1.next;
        }
        return pHead1;
    }

    private int getLength(ListNode pHead1) {
        int total = 0;
        while (pHead1 != null) {
            total++;
            pHead1 = pHead1.next;
        }
        return total;
    }

}
