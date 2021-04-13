package 剑指offer;

public class 合并两个排序的链表 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode cur;
        if (list1.val < list2.val) {
            cur = list1;
            cur.next = Merge(list1.next, list2);
        }else {
            cur = list2;
            cur.next = Merge(list1, list2.next);
        }
        return cur;
    }
}
