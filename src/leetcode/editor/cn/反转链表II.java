//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
// Related Topics 链表 
// 👍 895 👎 0

package leetcode.editor.cn;

import common.ListNode;
import common.Utils;

/**
 * [92] 反转链表 II </br>
 *
 * @see <a href="https://leetcode-cn.com/problems/reverse-linked-list-ii/">反转链表 II</a>
 */
public class 反转链表II {

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
         * 思路，left到right翻转，与未翻转的节点相连。
         * @param head
         * @param left
         * @param right
         * @return
         */
        public ListNode reverseBetween(ListNode head, int left, int right) {
            //记录left-1的node 和right+1的node
            //翻转left 到 right的链表。第一个元素是翻转后的尾，最后一个元素是翻转后的头
            ListNode leftNode = null;
            //找到需要翻转的node
            ListNode needReNode = head;
            int i = 1;
            while (needReNode != null && i < left) {
                leftNode = needReNode;
                needReNode = needReNode.next;
                i++;
            }
            ListNode pre = null; //翻转链表，pre就是翻转后的头
            ListNode last = needReNode; //last就是翻转后的尾
            int j = 0;
            //head = [1,2,3,4,5], left = 2, right = 4
            while (needReNode != null && j <= (right - left)) {
                ListNode next = needReNode.next;
                needReNode.next = pre;
                pre = needReNode;
                needReNode = next;
                j++;
            }
            if (leftNode != null) {
                //接上翻转后的头
                leftNode.next = pre;
            }
            //把尾巴也接上。
            last.next = needReNode;

            /**
             * 第一种情况，head没有被翻转，那么就是head
             * 第二种情况，head被翻转了。那要取pre
             */
            return leftNode != null ? head : pre;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 反转链表II().new Solution();
        //[1,2,3,4,5], left = 2, right = 4
//        ListNode listNode = solution.reverseBetween(Utils.toList("1,2,3,4,5"), 2, 4);
//        ListNode listNode = solution.reverseBetween(Utils.toList("5"), 1, 1);
        ListNode listNode = solution.reverseBetween(Utils.toList("1,5"), 1, 2);
        Utils.printListNode(listNode);
    }

}