//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid =  [1,3,1],
//             [1,5,1]
//             [4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 100 
// 
// Related Topics 数组 动态规划 
// 👍 868 👎 0

package leetcode.editor.cn;

/**
 * [64] 最小路径和 </br>
 *
 * @see <a href="https://leetcode-cn.com/problems/minimum-path-sum/">最小路径和</a>
 */
public class 最小路径和 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        Integer[][] memo;

        public int minPathSum(int[][] grid) {
            memo = new Integer[grid.length][grid[0].length];
            return dp(grid, 0, 0);
        }

        /**
         * 子问题 从下和左边选一个最小的路径 + 当前值
         * 状态，坐标
         * 选择：下边和左边
         *
         * @param grid
         * @param i
         * @param j
         * @return
         */
        public int dp(int[][] grid, int i, int j) {
            //base case
            if (i == grid.length - 1 && j == grid[0].length - 1) {
                //到了底部就结束。
                return grid[i][j];
            }
            if (memo[i][j] != null) {
                return memo[i][j];
            }
            int res;
            if (i == grid.length - 1) {
                //递归到底部了，就横向走
                res = dp(grid, i, j + 1) + grid[i][j];
            } else if (j == grid[0].length - 1) {
                //递归到边界了，就纵向走
                res = dp(grid, i + 1, j) + grid[i][j];
            } else {
                res = Math.min(dp(grid, i + 1, j), dp(grid, i, j + 1)) + grid[i][j];
            }
            memo[i][j] = res;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 最小路径和().new Solution();
    }

}