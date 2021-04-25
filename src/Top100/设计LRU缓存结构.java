package Top100;

import java.util.HashMap;
import java.util.Map;

/**
 * 设计LRU缓存结构，该结构在构造时确定大小，假设大小为K，并有如下两个功能
 * set(key, value)：将记录(key, value)插入该结构
 * get(key)：返回key对应的value值
 * [要求]
 * set和get方法的时间复杂度为O(1)
 * 某个key的set或get操作一旦发生，认为这个key的记录成了最常使用的。
 * 当缓存的大小超过K时，移除最不经常使用的记录，即set或get最久远的。
 * 若opt=1，接下来两个整数x, y，表示set(x, y)
 * 若opt=2，接下来一个整数x，表示get(x)，若x未出现过或已被移除，则返回-1
 * 对于每个操作2，输出一个答案
 */
public class 设计LRU缓存结构 {
}


/**
 * 思路
 * hash表 加 双向队列
 * <p>
 * 最久未访问的元素超出容量时会被删除
 * 最新被访问的元素会插入到头节点的下一位
 * 所以尾节点的上一位是最久未被访问的。可以直接删除，删除的时候，还需要同步删除hash表里的元素
 */
class LRUCache {

    static class Node {
        private int key;
        private int value;
        private Node pre;
        private Node next;

        public Node(int key, int value, Node pre, Node next) {
            this.key = key;
            this.value = value;
            this.pre = pre;
            this.next = next;
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.pre = null;
            this.next = null;
        }
    }

    private int size;
    private int capacity;
    private Map<Integer, Node> dict = new HashMap<>();
    private Node tail;
    private Node head;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.tail = new Node(-1, -1, null, null);
        this.head = new Node(-1, -1, null, tail);
        this.tail.pre = head;
    }

    public int get(int key) {
        Node node = dict.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    private void moveToHead(Node node) {
        //将元素移除
        removeNode(node);
        //插入头部
        insertHead(node);
    }

    private void insertHead(Node node) {
        //先设置node的pre 和 next
        node.pre = head;
        node.next = head.next;
        //head.next 是原先的下一个元素.pre 要指向node
        head.next.pre = node;
        //head的下一个元素要指向node
        head.next = node;
    }

    private void removeNode(Node node) {
        //node的上一个元素的next要指向node的下一个元素
        node.pre.next = node.next;
        //node下一个元素的pre要指向node的上一个元素，这样就从中间断开node，等于删除node
        node.next.pre = node.pre;
    }

    public void put(int key, int value) {
        Node node = dict.get(key);
        if (node == null) {
            Node newNode = new Node(key, value);
            dict.put(key, newNode);
            //这里是插入到头结点，但不是moveTohead
            insertHead(newNode);
            size++;
            if (size > capacity) {
                dict.remove(removeTail().key);
                size--;
            }
        } else {
            node.value = value;
            //移动到头结点
            moveToHead(node);
        }
    }

    private Node removeTail() {
        Node pre = tail.pre;
        removeNode(pre);
        return pre;
    }
}
