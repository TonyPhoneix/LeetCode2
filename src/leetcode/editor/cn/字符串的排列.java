//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 提示： 
//
// 
// 输入的字符串只包含小写字母 
// 两个字符串的长度都在 [1, 10,000] 之间 
// 
// Related Topics 双指针 Sliding Window 
// 👍 351 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * [567] 字符串的排列 </br>
 *
 * @see <a href="https://leetcode-cn.com/problems/permutation-in-string/">字符串的排列</a>
 */
public class 字符串的排列 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int left = 0;
            int right = 0;
            int valid = 0;
            Map<Character, Integer> window = new HashMap<>();
            Map<Character, Integer> need = new HashMap<>();
            for (int i = 0; i < s1.length(); i++) {
                char c = s1.charAt(i);
                need.put(c, need.getOrDefault(c, 0) + 1);
            }

            while (right < s2.length()) {
                //
                char rightC = s2.charAt(right);
                //
                if (need.containsKey(rightC)) {
                    //如果当前字符在需要的字符集中
                    //abacad, ca
                    window.put(rightC, window.getOrDefault(rightC, 0) + 1);
                    //TODO
                    if (window.get(rightC).equals(need.get(rightC))) {
                        valid++;
                    }
                }
                //判断窗口是否可以收缩，收缩的时机是当前窗口的长度是否等于s1的长度，如果大于就要移除left
                //abacad, ca
                if (right - left + 1 == s1.length()) {
                    //如果当前窗口的valid数量等于need，就返回true。
                    if (valid == need.size()) {
                        return true;
                    }
                    char leftC = s2.charAt(left);
                    left++; //收缩窗口
                    if (need.containsKey(leftC)) {
                        //如果当前字符在需要的字符集中
                        //abacad, ca
                        if (window.get(leftC).equals(need.get(leftC))) {
                            valid--;
                        }
                        window.put(leftC, window.getOrDefault(leftC, 0) - 1);
                    }
                }
                right++;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 字符串的排列().new Solution();
        solution.checkInclusion("ab", "aob");
    }

}