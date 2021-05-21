//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 5470 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * [3] 无重复字符的最长子串 </br>
 *
 * @see <a href="https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/">无重复字符的最长子串</a>
 */
public class 无重复字符的最长子串 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        /**
         * 思路，hash表存字符出现过的下表，双指针用来不断更新寻找子串。
         *
         * @param s
         * @return
         */
        public int lengthOfLongestSubstring2(String s) {
            if (s.length() == 0) {
                return 0;
            }
            //这个hashmap存的是下标
            Map<Character, Integer> map = new HashMap<>();
            int start = 0;
            int end = -1;
            int len = 0;
            for (int i = 0; i < s.length(); i++) {
                char key = s.charAt(i);
                Integer index = map.get(key);
                if (index != null) {
                    //abcabcbb
                    //有重复字符的话，就可以根据左右坐标算出当前串的长度。
                    //完事了，需要更新start坐标，start坐标的话的更新有两种情况
                    // abba，假设当前i= 3，start=2,end = 3,那start应该还是保证2
                    // baca，假设当前i= 3，start=0,end = 3,那start应该更新到2，也就是第一个a出现的后一个字符，也就是c
                    len = Math.max(len, end - start + 1);
                    start = Math.max(index + 1, start);
                }
                //1、更新key的下标
                map.put(key, i);
                end += 1;
            }
            return Math.max(len, end - start + 1);
        }

        public int lengthOfLongestSubstring(String s) {
            if (s.length() == 0) {
                return 0;
            }
            //这个hashmap存的是元素的个数
            Map<Character, Integer> map = new HashMap<>();
            int left = 0;
            int right = 0;
            int len = 0;
            while (right < s.length()) {
                char c = s.charAt(right);
                map.put(c, map.getOrDefault(c, 0) + 1);
                //判断是否能缩小窗口
                while (map.get(c) > 1) {
                    //当前元素重复了
                    char leftC = s.charAt(left);
                    map.put(leftC, map.get(leftC) - 1);
                    left++;
                }
                len = Math.max(len, right - left + 1);
                right++;
            }
            return len;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 无重复字符的最长子串().new Solution();
        int abcabcbb = solution.lengthOfLongestSubstring("abba");
        System.out.println(abcabcbb);
    }

}