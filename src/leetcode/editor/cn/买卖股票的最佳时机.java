//给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。 
//
// 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。 
//
// 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：[7,1,5,3,6,4]
//输入：[7,1,5,3,6,4]
//输出：5
//解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
// 
//
// 示例 2： 
//
// 
//输入：prices = [7,6,4,3,1]
//输出：0
//解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 105 
// 0 <= prices[i] <= 104 
// 
// Related Topics 数组 动态规划 
// 👍 1591 👎 0

package leetcode.editor.cn;

/**
 * [121] 买卖股票的最佳时机 </br>
 *
 * @see <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/">买卖股票的最佳时机</a>
 */
public class 买卖股票的最佳时机 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Integer[] memo;
        int minPrice = Integer.MAX_VALUE;

        public int maxProfit(int[] prices) {
            //非动态规划解法
            int max = 0;
            for (int i = 1; i < prices.length; i++) {
                if (minPrice > prices[i - 1]) {
                    minPrice = prices[i - 1];
                }
                max = Math.max(max, prices[i] - minPrice);
            }
            return max;
        }


        /**
         * 动态规划解法，时间复杂度O（N），空间复杂度O(N)
         *
         * @param prices
         * @return
         */
        public int maxProfit1(int[] prices) {
            if (prices.length <= 1) {
                return 0;
            }
            memo = new Integer[prices.length];
            memo[1] = prices[1] - prices[0];
            int max = 0;
            for (int i = 1; i < prices.length; i++) {
                max = Math.max(max, dp(prices, i));
            }
            return max;
        }

        /**
         * 子问题：
         * 会变化的就是状态
         * 状态：dp[i]表示第i天卖出的最大利润, i从1开始，因为第一天无法卖出
         * 选择：如果dp[i-1]是正数，那么最大利润 = dp[i-1] + (prices[i]-prices[i-1])
         * 如果dp[i-1]是负数，那么从前面找一个比prices[i]小的值，也就是历史股价最低值。作为dp[i]的值
         *
         * @param prices
         * @return
         */
        public int dp(int[] prices, int i) {
            if (i == 1) {
                return memo[i];
            }
            if (memo[i] != null) {
                return memo[i];
            }
            if (minPrice > prices[i - 1]) {
                //实时更新最低价
                minPrice = prices[i - 1];
            }
            int res = dp(prices, i - 1);
            int income;
            if (res < 0) {
                //找到最小的j值，作为答案返回回去
                income = minPrice == Integer.MAX_VALUE ? 0 : prices[i] - minPrice;
            } else {
                income = res + (prices[i] - prices[i - 1]);
            }
            memo[i] = income;
            return income;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 买卖股票的最佳时机().new Solution();
        int i = solution.maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println(i);
    }

}