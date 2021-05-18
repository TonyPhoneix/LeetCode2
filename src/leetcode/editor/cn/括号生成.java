//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1785 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * [22] 括号生成 </br>
 *
 * @see <a href="https://leetcode-cn.com/problems/generate-parentheses/">括号生成</a>
 */
public class 括号生成 {


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> res;

        public List<String> generateParenthesis(int n) {
            res = new ArrayList<>();
            dp("", n, n);
            return res;
        }

        /**
         * @param s     path
         * @param left  左括号剩余
         * @param right 右括号剩余
         */
        public void dp(String s, int left, int right) {
            //假设s
            if (left == 0 && right == 0) {
                //check 括号
                res.add(s);
                return;
            }

            if (left > 0) {
                //还有左括号
                dp(s + "(", left - 1, right);
            }
            if (right > left) {
                // 如果右括号剩余多于左括号剩余的话，可以拼接右括号
                dp(s + ")", left, right - 1);
            }
        }

        //检查是否是合法的括号序列
        private boolean check(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(')');
                } else {
                    Character pop;
                    try {
                        pop = stack.pop();
                    } catch (Exception e) {
                        return false;
                    }
                    if (pop != ')') {
                        return false;
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 括号生成().new Solution();
        List<String> strings = solution.generateParenthesis(3);
        System.out.println(strings);
    }

}