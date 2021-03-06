//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 进阶： 
//
// 
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 104] 内 
// -105 <= Node.val <= 105 
// 
// Related Topics 排序 链表 
// 👍 1112 👎 0

package leetcode.editor.cn;

import common.ListNode;
import common.Utils;

/**
 * [148] 排序链表 </br>
 *
 * @see <a href="https://leetcode-cn.com/problems/sort-list/">排序链表</a>
 */
public class 排序链表 {

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

        //选择排序的思路，时间复杂度ON2 ,超出限制，明天用归并排序写吧
        public ListNode sortList2(ListNode head) {
            ListNode h = new ListNode(0);
            h.next = head;
            ListNode cur = head; //在head链表上进行中的节点
            while (cur != null) {
                ListNode next = cur.next;
                //2,4,5,1,2 => 1,4,5,2,2
                ListNode min = selectMin(cur);
                int temp = cur.val;
                cur.val = min.val;
                min.val = temp;
                //然后交换
                //cur更新到下一个
                cur = next;
            }
            return h.next;
        }


        public ListNode selectMin(ListNode head) {
            //找到比val大的第一个值
            int min = Integer.MAX_VALUE;
            ListNode minNode = null;
            while (head != null) {
                if (head.val < min) {
                    minNode = head;
                    min = head.val;
                }
                head = head.next;
            }
            return min == Integer.MAX_VALUE ? null : minNode;
        }

        /**
         * 归并排序的思路，先二分到不能在二分了，然后对相邻的节点，进行排序，返回一个新的有序链表再排序
         *
         * @param start
         * @return
         */
        //4,2,1
        public ListNode sortList(ListNode start) {
            if (start == null || start.next == null) {
                return start;
            }
            //fast 先走一步
            ListNode fast = start.next;
            ListNode slow = start;

            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            //这里很关键：要断开链表，才有正确的边界
            ListNode next = slow.next;
            slow.next = null;
            //作用其实就是二分到不能再二分了，然后开始merge
            ListNode l1 = sortList(start);
            ListNode l2 = sortList(next);
            return merge(l1, l2);
        }

        public ListNode merge(ListNode l1, ListNode l2) {
            ListNode t = new ListNode(0);
            ListNode pre = t;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    pre.next = l1;
                    l1 = l1.next;
                } else {
                    pre.next = l2;
                    l2 = l2.next;
                }
                pre = pre.next;
            }

            if (l1 != null) {
                pre.next = l1;
            }

            if (l2 != null) {
                pre.next = l2;
            }
            return t.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 排序链表().new Solution();
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode four = new ListNode(4);
        four.next = two;
        two.next = one;
        ListNode listNode = solution.sortList(four);
        Utils.printListNode(listNode);
    }

}