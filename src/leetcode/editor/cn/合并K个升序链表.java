//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 堆 链表 分治算法 
// 👍 1277 👎 0

package leetcode.editor.cn;

import common.ListNode;
import common.Utils;

/**
 * [23] 合并K个升序链表 </br>
 *
 * @see <a href="https://leetcode-cn.com/problems/merge-k-sorted-lists/">合并K个升序链表</a>
 */
public class 合并K个升序链表 {

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0) {
                return null;
            }
            if (lists.length == 1) {
                return lists[0];
            }
            //feibonaqie
            ListNode first = lists[0];
            ListNode second = lists[1];
            ListNode total = merge(first, second);
            for (int i = 2; i < lists.length; i++) {
                first = total;
                second = lists[i];
                total = merge(first, second);
            }
            return total;
        }

        /**
         * 思路，归并算法
         *
         * @param l1
         * @param l2
         * @return
         */
        public ListNode merge(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(0);
            ListNode pre = head;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    pre.next = l1;
                    pre = l1;
                    l1 = l1.next;
                } else {
                    pre.next = l2;
                    pre = l2;
                    l2 = l2.next;
                }
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
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 合并K个升序链表().new Solution();
        ListNode listNode = solution.mergeKLists(new ListNode[]{null, new ListNode(1)});
        Utils.printListNode(listNode);
    }

}