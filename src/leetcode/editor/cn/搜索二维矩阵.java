//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -104 <= matrix[i][j], target <= 104 
// 
// Related Topics 数组 二分查找 
// 👍 437 👎 0

package leetcode.editor.cn;

/**
 * [74] 搜索二维矩阵 </br>
 *
 * @see <a href="https://leetcode-cn.com/problems/search-a-2d-matrix/">搜索二维矩阵</a>
 */
public class 搜索二维矩阵 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            //横向升序，纵向升序
            int row = matrix.length - 1;
            int col = 0;
            while (row >= 0 && col < matrix[0].length) {
                if (matrix[row][col] == target) {
                    return true;
                } else if (matrix[row][col] < target) {
                    //小于target就横向走
                    col++;
                } else {
                    //大于 target，纵向走
                    row--;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 搜索二维矩阵().new Solution();
    }

}