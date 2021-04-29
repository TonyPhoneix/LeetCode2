//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 1129 👎 0

package leetcode.editor.cn;

/**
 * [200] 岛屿数量 </br>
 *
 * @see <a href="https://leetcode-cn.com/problems/number-of-islands/">岛屿数量</a>
 */
public class 岛屿数量 {


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 思路：dfs，深度遍历，遍历到的1都改为0，然后再次遍历，岛屿的数量就是dfs的次数
         *
         * @param grid
         * @return
         */
        private boolean[][] visited;

        public int numIslands(char[][] grid) {

            int num = 0;
            visited = new boolean[grid.length][grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == '1') {
                        dfs(grid, i, j);
                        num++;
                    }
                }
            }
            return num;
        }

        /**
         * dfs(i,j)的周围是否都是陆地
         *
         * @param grid
         * @param i
         * @param j
         * @return
         */
        public void dfs(char[][] grid, int i, int j) {
            //控制好边界
            if (i == -1 || i == grid.length || j == -1 || j == grid[0].length || visited[i][j]) {
                return;
            }
            if (grid[i][j] == '1') {
                //记录访问过的元素，避免重复访问死循环
                visited[i][j] = true;
                //如果本身是陆地，就看看左边和下边是不是陆地
                grid[i][j] = '0';
                //四个方向深度遍历
                dfs(grid, i + 1, j);
                dfs(grid, i - 1, j);
                dfs(grid, i, j + 1);
                dfs(grid, i, j - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 岛屿数量().new Solution();
        int i = solution.numIslands(new char[][]{{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}});
        System.out.println(i);
    }

}