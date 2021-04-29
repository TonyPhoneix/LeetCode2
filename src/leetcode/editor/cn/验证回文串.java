//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 373 👎 0

package leetcode.editor.cn;

/**
 * [125] 验证回文串 </br>
 *
 * @see <a href="https://leetcode-cn.com/problems/valid-palindrome/">验证回文串</a>
 */
public class 验证回文串 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            return isPalindrome(s.toLowerCase(), 0, s.length() - 1);
        }

        public boolean isPalindrome(String s, int left, int right) {
            if (left >= right) {
                return true;
            }
            char leftChar = s.charAt(left);
            if (!isValidChar(leftChar)) {
                return isPalindrome(s, left + 1, right);
            }
            char rightChar = s.charAt(right);
            if (!isValidChar(rightChar)) {
                return isPalindrome(s, left, right - 1);
            }
            if (leftChar != rightChar) {
                return false;
            } else {
                return isPalindrome(s, left + 1, right - 1);
            }
        }

        public boolean isValidChar(char c) {
            return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z');
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 验证回文串().new Solution();
        solution.isPalindrome("A man, a plan, a canal: Panama");
    }

}