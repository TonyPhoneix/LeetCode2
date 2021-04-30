//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。 
//
// 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
//输出: 2 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/ 
//
// 
// Related Topics 位运算 分治算法 
// 👍 146 👎 0

package leetcode.editor.cn;

/**
 * [剑指 Offer 39] 数组中出现次数超过一半的数字 </br>
 *
 * @see <a href="https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/">数组中出现次数超过一半的数字</a>
 */
public class 数组中出现次数超过一半的数字 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //谁票多就是谁，
        public int majorityElement(int[] nums) {

            int v = 1;
            int res = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (v == 0) {
                    //如果投票为0，就从当前重新开始
                    res = nums[i];
                    v++;
                    continue;
                }
                if (nums[i] == res) {
                    v++;
                } else {
                    v--;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 数组中出现次数超过一半的数字().new Solution();
    }

}