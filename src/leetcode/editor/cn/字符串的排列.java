//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 回溯算法 
// 👍 256 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * [剑指 Offer 38] 字符串的排列 </br>
 *
 * @see <a href="https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/">字符串的排列</a>
 */
public class 字符串的排列 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        Set<String> result;

        public String[] permutation(String s) {
            char[] chars = s.toCharArray();
            boolean[] map = new boolean[s.length()];
            result = new HashSet<>();
            backtracking("", map, chars);
            return result.toArray(String[]::new);
        }

        /**
         * 思路，回溯算法，列出所有的可能。
         * 回溯算法的框架，
         * 状态：i
         * 选择：
         * 撤销选择：
         *
         * @return
         */
        public void backtracking(String roads, boolean[] map, char[] arrays) {
            if (roads.length() == arrays.length) {
                //走到头了
                result.add(roads);
                return;
            }
            //穷举当前的所有选择。
            for (int i = 0; i < arrays.length; i++) {
                if (map[i]) {
                    //如果已经出现过，则跳过
                    continue;
                }
                map[i] = true;
                //选择，加上新的字符
                backtracking(roads + (arrays[i]), map, arrays);
                //撤销选择，roads保持原样
                map[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 字符串的排列().new Solution();
        System.out.println(Arrays.toString(solution.permutation("aab")));
    }

}