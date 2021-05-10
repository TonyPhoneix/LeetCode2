//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "1 + 1"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：s = " 2-1 + 2 "
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：s = "(1+(4+(5+2559))-3)+(6+8)"
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由数字、'+'、'-'、'('、')'、和 ' ' 组成 
// s 表示一个有效的表达式 
// 
// Related Topics 栈 数学 
// 👍 559 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * [224] 基本计算器 </br>
 *
 * @see <a href="https://leetcode-cn.com/problems/basic-calculator/">基本计算器</a>
 */
public class 基本计算器 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        class Res {
            int res;
            int right;

            public Res(int res, int right) {
                this.res = res;
                this.right = right;
            }
        }

        /**
         * @param s
         * @return
         */
        public int calculate(String s) {
            String trim = s.replaceAll(" ", "");
            try {
                return Integer.parseInt(trim);
            } catch (Exception e) {
                return cal(trim.toCharArray(), 0).res;
            }
        }


        // 计算一个正常的表达式，遇到括号就递归，用双端队列来计算
        public Res cal(char[] c, int left) {
            Deque<Integer> nums = new LinkedList<>();
            char preOp = '+';
            int right = -1;
            for (int i = left; i < c.length; i++) {
                char n = c[i];
                //对首字符是正负的进行特殊处理。
                if (i == left && (n == '-' || n == '+')) {
                    //如果第一个值为负数 - ，加上一个0，方便计算
                    nums.offer(0);
                    if (n == '-') {
                        preOp = '-';
                    } else {
                        preOp = '+';
                    }
                    continue;
                }
                //算数字
                boolean isDigit = false;
                int res = 0;
                while (i < c.length && Character.isDigit(c[i])) {
                    //如果是数字
                    res = c[i] - '0' + res * 10;
                    i++;
                    isDigit = true;
                }
                if (isDigit) {
                    //如果是数字
                    //当前i已经更新到非数字了。为了正确的for循环，需要-1
                    i--;
                    //如果上一个操作符是乘除，需要先计算
                    if (preOp == '*' || preOp == '/') {
                        Integer pop = nums.pollLast();
                        nums.offer(preOp == '*' ? pop * res : pop / res);
                        //preOp重置
                    } else if (preOp == '+') {
                        nums.offer(res);
                    } else if (preOp == '-') {
                        nums.offer(-res);
                    }
                } else if (n == ')') {
                    //遇到括号就停止
                    right = i;
                    break;
                } else if (n == '(') {
                    //进行递归子表达式
                    Res cal = cal(c, i + 1);
                    if (preOp == '*' || preOp == '/') {
                        Integer pop = nums.pollLast();
                        nums.offer(preOp == '*' ? pop * cal.res : pop / cal.res);
                        //preOp重置
                    } else if (preOp == '+') {
                        nums.offer(cal.res);
                    } else if (preOp == '-') {
                        nums.offer(-cal.res);
                    }
                    i = cal.right;
                } else {
                    preOp = n;
                }
            }
            //累加计算结果
            int res = 0;
            while (!nums.isEmpty()) {
                res += nums.pop();
            }
            return new Res(res, right);
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 基本计算器().new Solution();
//        Solution.Res cal = solution.cal(new char[]{'1', '-', '2', '+', '3'}, 0);

//        int cal = solution.calculate("-2+ 1");
//        int cal = solution.calculate("- (3 + (4 + 5))");
        int cal = solution.calculate("1 *(1 + 1 *(-10))");
//        int cal = solution.calculate("1-11");
        System.out.println(cal);
    }

}