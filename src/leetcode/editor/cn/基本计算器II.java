//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 整数除法仅保留整数部分。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "3+2*2"
//输出：7
// 
//
// 示例 2： 
//
// 
//输入：s = " 3/2 "
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：s = " 3+5 / 2 "
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开 
// s 表示一个 有效表达式 
// 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内 
// 题目数据保证答案是一个 32-bit 整数 
// 
// 
// 
// Related Topics 栈 字符串 
// 👍 392 👎 0

package leetcode.editor.cn;

import java.util.Stack;

/**
 * [227] 基本计算器 II </br>
 *
 * @see <a href="https://leetcode-cn.com/problems/basic-calculator-ii/">基本计算器 II</a>
 */
public class 基本计算器II {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String s) {
            String s2 = s.replace(" ", "");
            char[] chars = s2.toCharArray();
            Stack<Integer> nums = new Stack<>();
            char preOp = '+'; //记录上一个操作符
            //1 * 2 + 3
            for (int i = 0; i < chars.length; i++) {
                //取整数
                char c = chars[i];
                if (Character.isDigit(c)) {
                    int index = i;
                    int res = 0;
                    while (index < chars.length && Character.isDigit(chars[index])) {
                        res = (chars[index++] - '0') + res * 10;
                    }
                    i = index - 1;

                    if ((preOp == '*' || preOp == '/')) {
                        //不是数字
                        // 因为 * / 优先级高，所以先计算，然后入栈
                        Integer n1 = nums.pop();
                        nums.push(preOp == '*' ? res * n1 : n1 / res);
                    } else if (preOp == '-') {
                        //负数的话，加上-号入栈
                        nums.push(-res);
                    } else {
                        nums.push(res);
                    }
                } else {
                    //更新操作符
                    preOp = c;
                }
            }

            int res = 0;
            while (!nums.isEmpty()) {
                res += nums.pop();
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 基本计算器II().new Solution();
//        int calculate = solution.calculate("1+2 * 3 -3");
//        int calculate = solution.calculate("1*2 + 3");
        int calculate = solution.calculate("3/2");
        System.out.println(calculate);
    }

}