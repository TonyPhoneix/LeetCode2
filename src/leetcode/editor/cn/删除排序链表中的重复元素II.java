//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 返回同样按升序排列的结果链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序排列 
// 
// Related Topics 链表 
// 👍 613 👎 0

package leetcode.editor.cn;

import common.ListNode;

/**
 * [82] 删除排序链表中的重复元素 II </br>
 *
 * @see <a href="https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/">删除排序链表中的重复元素 II</a>
 */
public class 删除排序链表中的重复元素II {

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
        public ListNode deleteDuplicates(ListNode head) {
            //从当前元素，往后查找，如果重复，就返回最后一个节点，与pre节点相连
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode pre = dummy;
            ListNode cur = head;
            //1,1,2 => 2
            while (cur != null) {
                ListNode next = cur.next;
                if (next != null && next.val == cur.val) {
                    ListNode noRepeatNode = findNoRepeatNode(cur);
                    pre.next = noRepeatNode;
                    cur = noRepeatNode;
                } else {
                    pre = cur;
                    cur = next;
                }
            }
            return dummy.next;
        }

        //1,1,1,2 =>2
        //1,1=>1
        private ListNode findNoRepeatNode(ListNode head) {
            ListNode cur = head;
            while (cur != null) {
                ListNode next = cur.next;
                if (next != null && cur.val == next.val) {
                    cur = next;
                } else {
                    return next;
                }
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 删除排序链表中的重复元素II().new Solution();
    }

}