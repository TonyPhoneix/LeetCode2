package 链表;

/**
 * 给出链表，使得每个节点包含可以指向列表中的任何节点或空值的附加随机指针。
 * 返回列表的深层副本。
 * Created by Tony on 2017/5/17.
 */
public class 复杂链表的复制 {
    public static RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        RandomListNode cur = head;
        RandomListNode next;
        //复制每个节点到源节点的后面
        while (cur != null) {
            next = cur.next;
            RandomListNode tmp = new RandomListNode(cur.label);
            cur.next = tmp;
            tmp.next = next;
            cur = next;
        }
        //再复制random引用
        cur = head;
        while (cur != null && cur.next !=null) {
            RandomListNode tmp = cur.next;
            if (cur.random != null) {
                tmp.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        //分拆两个链表
        cur = head;
        RandomListNode rcur = cur.next;
        RandomListNode rhead = rcur;
        while (cur != null && cur.next.next!=null) {
            next = cur.next.next;
            rcur.next = next.next;
            cur = next;
            rcur = cur.next;
        }
        return rhead;
    }

    public static void main(String[] args) {
        RandomListNode node = new RandomListNode(1);
        node.next = new RandomListNode(2);
        RandomListNode randomListNode = copyRandomList(node);
        while (randomListNode != null) {
            System.out.println(randomListNode.label);
            randomListNode = randomListNode.next;
        }
    }
}
