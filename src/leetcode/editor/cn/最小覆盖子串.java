//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 1159 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * [76] 最小覆盖子串 </br>
 *
 * @see <a href="https://leetcode-cn.com/problems/minimum-window-substring/">最小覆盖子串</a>
 */
public class 最小覆盖子串 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            //window 统计当前窗口内字符的数量，need表示需要的字符和数量
            Map<Character, Integer> window = new HashMap<>(), need = new HashMap<>();
            int valid = 0;
            //双指针
            int left = 0;
            int right = 0;
            int start = 0; //最小覆盖子串的起点
            int len = Integer.MAX_VALUE; //最小覆盖子串的长度
            //初始化need
            for (int i = 0; i < t.length(); i++) {
                char key = t.charAt(i);
                need.put(key, need.getOrDefault(key, 0) + 1);
            }

            while (right < s.length()) {
                char c = s.charAt(right);
                //把元素放进去
                if (need.containsKey(c)) {
                    //如果包含的话，就需要加到窗口里
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if (window.get(c).equals(need.get(c))) {
                        valid++;
                    }
                }

                //判断窗口是否要收缩
                while (valid == need.size()) {
                    //如果valid个数相等，就记录长度，然后缩小left
                    //a,b,c,a,c  a,c
                    if (len > right - left + 1) {
                        len = right - left + 1;
                        start = left;
                    }
                    char leftC = s.charAt(left);
                    left++;
                    //把leftC移除
                    if (need.containsKey(leftC)) {
                        //如果包含这个字符，就移除，并判断window是否还满足需求。
                        if (window.get(leftC).equals(need.get(leftC))) {
                            valid--;
                        }
                        window.put(leftC, window.get(leftC) - 1);
                    }
                }
                //right右移
                right++;
            }
            return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 最小覆盖子串().new Solution();
        String s = solution.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }

}