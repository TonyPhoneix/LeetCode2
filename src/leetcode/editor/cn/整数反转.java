//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics 数学 
// 👍 2802 👎 0

package leetcode.editor.cn;

/**
 * [7] 整数反转 </br>
 *
 * @see <a href="https://leetcode-cn.com/problems/reverse-integer/">整数反转</a>
 */
public class 整数反转 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            //123 => 321
            long res = 0;
            while (x != 0) {
                //123 => 3
                //12 => 2+30 = 32
                //1 => 1 + 320 = 321
                res = x % 10 + res * 10;
                if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
                    return 0;
                }
                x = x / 10;
            }
            return (int) res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 整数反转().new Solution();
    }

}