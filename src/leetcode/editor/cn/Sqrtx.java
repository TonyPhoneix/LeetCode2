//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 665 👎 0

package leetcode.editor.cn;

/**
 * [69] x 的平方根 </br>
 *
 * @see <a href="https://leetcode-cn.com/problems/sqrtx/">x 的平方根</a>
 */
public class Sqrtx {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            int sqrt = sqrt(x, 0, x);
            return sqrt * sqrt > x ? sqrt - 1 : sqrt;
        }

        public int sqrt(int x, int start, int end) {
            if (x == 0) {
                return 0;
            }
            if (x == 1) {
                return 1;
            }
            if (start >= end) {
                return start;
            }
            int mid = (start + end) / 2;
            long res = (long) mid * mid;
            if (res == x) {
                return mid;
            } else if (res < x) {
                //小于
                return sqrt(x, mid + 1, end);
            } else {
                //大于
                return sqrt(x, start, mid - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();
    }

}