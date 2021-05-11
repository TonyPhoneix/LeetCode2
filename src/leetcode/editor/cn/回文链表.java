//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 971 👎 0

package leetcode.editor.cn;

import common.ListNode;
import common.Utils;

/**
 * [234] 回文链表 </br>
 *
 * @see <a href="https://leetcode-cn.com/problems/palindrome-linked-list/">回文链表</a>
 */
public class 回文链表 {

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


        /**
         * 思路：找到链表的中点，然后反转后边的链表，然后同时遍历。
         *
         * @param head
         * @return
         */
        public boolean isPalindrome(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            //1 , 2, 2, 1
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }

            ListNode r = reverse(slow);
            while (head != null && r != null) {
                if (head.val != r.val) {
                    return false;
                }
                head = head.next;
                r = r.next;
            }
            return true;
        }

        private ListNode reverse(ListNode head) {
            //原地反转链表
            ListNode pre = null;
            while (head != null) {
                ListNode next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            return pre;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 回文链表().new Solution();
        boolean palindrome = solution.isPalindrome(Utils.toList("1,2,2,1"));
        System.out.println(palindrome);
    }

}