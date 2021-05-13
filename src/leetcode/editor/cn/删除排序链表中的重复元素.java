//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。 
//
// 返回同样按升序排列的结果链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,1,2]
//输出：[1,2]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,2,3,3]
//输出：[1,2,3]
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
// 👍 573 👎 0

package leetcode.editor.cn;

import common.ListNode;

/**
 * [83] 删除排序链表中的重复元素 </br>
 *
 * @see <a href="https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/">删除排序链表中的重复元素</a>
 */
public class 删除排序链表中的重复元素 {

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
            //遍历链表，如果当前元素和上一个元素重复，则删除当前元素
            ListNode cur = head;
            ListNode pre = null;
            while (cur != null) {
                ListNode next = cur.next;
                if (pre != null && cur.val == pre.val) {
                    //移除
                    pre.next = next;
                }else {
                    pre = cur;
                }
                cur = next;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 删除排序链表中的重复元素().new Solution();
    }

}