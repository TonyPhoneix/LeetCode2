package common;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Base {

    public int count;

    public void print(int n, String s) {
        for (int i = 0; i < n; i++) {
            System.out.print("    ");
        }
        System.out.print(s);
        System.out.println();
    }

    public int[][] toMatrix(String template) {
        //[1,2],[2,3],[3,4],[3,5],[4,5],[5,5],[5,6],[6,7],[7,8]
        var row = template.replace("[", "").split("]");
        var col = row[0].split(",");
        int[][] matrix = new int[row.length][col.length];
        for (int i = 0; i < row.length; i++) {
            var colStr = row[i];
            var split = colStr.split(",");
            var list = Arrays.stream(split).filter(this::isNotBlank).map(Integer::parseInt).collect(Collectors.toList());
            for (int j = 0; j < list.size(); j++) {
                matrix[i][j] = list.get(j);
            }
        }
        return matrix;
    }

    public ListNode toList(String template) {
        ListNode head = new ListNode(0);
        ListNode pre = head;
        var split = template.split(",");
        for (int i = 0; i < split.length; i++) {
            ListNode cur = new ListNode(Integer.parseInt(split[i]));
            pre.next = cur;
            pre = cur;
        }
        return head.next;
    }

    public void printListNode(ListNode node) {
        if (node == null) {
            System.out.println("null");
            return;
        }
        while (node.next != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.print(node.val);
    }

    private boolean isNotBlank(String s) {
        return s != null && s.length() != 0;
    }
}
