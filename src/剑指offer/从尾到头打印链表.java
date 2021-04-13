package 剑指offer;

import 链表.ListNode;

import java.util.ArrayList;

/**
 * Created by huajian.yuan on 2017/9/4.
 */
public class 从尾到头打印链表 {
    ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        print(listNode);
        return list;
    }

    private void print(ListNode listNode) {
        if (listNode == null) {
            return;
        }
        print(listNode.next);
        list.add(listNode.val);
    }


}
