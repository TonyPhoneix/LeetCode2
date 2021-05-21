//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：nums = [-1]
//输出：-1
// 
//
// 示例 5： 
//
// 
//输入：nums = [-100000]
//输出：-100000
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// -105 <= nums[i] <= 105 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 3240 👎 0

package leetcode.editor.cn;

/**
 * [53] 最大子序和 </br>
 *
 * @see <a href="https://leetcode-cn.com/problems/maximum-subarray/">最大子序和</a>
 */
public class 最大子序和 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        Integer[] memo;

        public int maxSubArray(int[] nums) {
            memo = new Integer[nums.length];
            int res = nums[0];
            memo[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int max = dp(nums, i);
                res = Math.max(res, max);
            }
            return res;
        }

        /**
         * 状态，dp[i]表示0~i下标的数组的最大和。
         * 选择：上一个值+当前值  和  当前值选最大。
         *
         * @param nums
         * @param i
         * @return
         */
        public int dp(int[] nums, int i) {
            if (memo[i] != null) {
                return memo[i];
            }
            int max = Math.max(dp(nums, i - 1) + nums[i], nums[i]);
            memo[i] = max;
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 最大子序和().new Solution();
    }

}