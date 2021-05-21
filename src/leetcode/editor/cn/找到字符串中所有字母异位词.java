//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。 
//
// 说明： 
//
// 
// 字母异位词指字母相同，但排列不同的字符串。 
// 不考虑答案输出的顺序。 
// 
//
// 示例 1: 
//
// 
//输入:
//s: "cbaebabacd" p: "abc"
//
//输出:
//[0, 6]
//
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
// 
//
// 示例 2: 
//
// 
//输入:
//s: "abab" p: "ab"
//
//输出:
//[0, 1, 2]
//
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
// 
// Related Topics 哈希表 
// 👍 528 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * [438] 找到字符串中所有字母异位词 </br>
 *
 * @see <a href="https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/">找到字符串中所有字母异位词</a>
 */
public class 找到字符串中所有字母异位词 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();
            String s1 = p;
            String s2 = s;
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
                    if (window.get(rightC).equals(need.get(rightC))) {
                        valid++;
                    }
                }
                //判断窗口是否可以收缩，收缩的时机是当前窗口的长度是否等于s1的长度，如果大于就要移除left
                //abacad, ca
                if (right - left + 1 == s1.length()) {
                    //如果当前窗口的valid数量等于need，就返回true。
                    if (valid == need.size()) {
                        res.add(left);
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
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 找到字符串中所有字母异位词().new Solution();
    }

}