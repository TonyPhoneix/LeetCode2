// 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics 排序 数组 
// 👍 923 👎 0

package leetcode.editor.cn;

import common.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [56] 合并区间 </br>
 *
 * @see <a href="https://leetcode-cn.com/problems/merge-intervals/">合并区间</a>
 */
public class 合并区间 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 思路：按照起点排序，按照终点降序
         * <p>
         * 有三种情况
         * 1、覆盖
         * 2、相交
         * 3、分离
         * 初始化一个区间，如果覆盖，则消灭区间。
         * 如果相交，则更新区间大小
         * 如果分离，则将当前区间加入结果集，并且更新区间
         *
         * @param intervals
         * @return
         */
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (o1, o2) -> {
                //将区间，按照起点升序，终点降序的方法排序。
                int i = o1[0] - o2[0];
                return i == 0 ? o2[1] - o1[1] : i;
            });

            List<int[]> res = new ArrayList<>();
            int[] start = intervals[0];
            for (int i = 1; i < intervals.length; i++) {
                int[] interval = intervals[i];
                if (interval[0] >= start[0] && interval[1] <= start[1]) {
                    //覆盖
                    continue;
                }
                if (interval[0] <= start[1]) {
                    //相交
                    start[1] = interval[1];
                    continue;
                }
                //如果分离，则把上一个区间加入结果集
                res.add(start);
                start = new int[]{interval[0], interval[1]};
            }
            res.add(start);
            return res.toArray(new int[][]{});
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 合并区间().new Solution();
        int[][] merge = solution.merge(Utils.toMatrix("[2,3],[2,2],[3,3],[1,3],[5,7],[2,2],[4,6]"));
    }

}