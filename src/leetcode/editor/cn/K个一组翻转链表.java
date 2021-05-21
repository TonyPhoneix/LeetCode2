//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 进阶： 
//
// 
// 你可以设计一个只使用常数额外空间的算法来解决此问题吗？ 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2,3,4,5], k = 1
//输出：[1,2,3,4,5]
// 
//
// 示例 4： 
//
// 
//输入：head = [1], k = 1
//输出：[1]
// 
//
// 
// 
//
// 提示： 
//
// 
// 列表中节点的数量在范围 sz 内 
// 1 <= sz <= 5000 
// 0 <= Node.val <= 1000 
// 1 <= k <= sz 
// 
// Related Topics 链表 
// 👍 1106 👎 0

package leetcode.editor.cn;

import common.ListNode;

/**
 * [25] K 个一组翻转链表 </br>
 *
 * @see <a href="https://leetcode-cn.com/problems/reverse-nodes-in-k-group/">K 个一组翻转链表</a>
 */
public class K个一组翻转链表 {

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
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode d = new ListNode(-1);
            d.next = head;

            //lastGroupNode定义为上一组反转链表的尾节点，用来连接下一组
            ListNode lastGroupNode = d;
            //连续反转一组链表
            while (canRevert(head, k)) {
                //指定k个元素反转链表。
                int i = 0;
                ListNode pre = null;
                ListNode last = head;
                while (i < k) {
                    //反转一组链表
                    // 0 -> 1 -> 2  head = 2; pre = 1; last = 0
                    ListNode next = head.next;
                    head.next = pre;
                    pre = head;
                    head = next;
                    i++;
                }
                //pre就是链表反转后的头， last 就是反转后的尾 head就是下一段链表的头。
                //上一组的尾连接这一组的头
                lastGroupNode.next = pre;
                //这一组的尾连接下一组的头
                last.next = head;
                //更新lastGroupNode
                lastGroupNode = last;
            }
            //连接剩下的节点。
            lastGroupNode.next = head;
            return d.next;
        }

        private boolean canRevert(ListNode head, int k) {
            int i = 0;
            //2个  n1 -> n2;
            while (i < k && head != null) {
                head = head.next;
                i++;
            }
            return i == k;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new K个一组翻转链表().new Solution();
    }

}