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


        // 一个计算单元
        // (b - c)
        //left 是括号
        public Res cal(char[] c, int left) {
            Deque<Integer> nums = new LinkedList<>();
            Deque<Character> ops = new LinkedList<>();
            int right = -1;
            for (int i = left; i < c.length; i++) {
                char n = c[i];
                int last = isNumber(c, i);
                if (i == left && n == '-') {
                    //第一个值为负数 - ，加上一个0，方便计算
                    nums.offer(0);
                    ops.offer('-');
                } else if (last != -1) {
                    //如果是数字
                    nums.offer(getNumber(c, i, last));
                    i = last;
                } else if (n == ')') {
                    //遇到括号就停止
                    right = i;
                    break;
                } else if (n == '(') {
                    Res cal = cal(c, i + 1);
                    nums.offer(cal.res);
                    i = cal.right;
                } else {
                    ops.offer(n);
                }
            }
            //初始化完成，计算结果。
            while (!ops.isEmpty()) {
                Integer p1 = nums.poll();
                Integer p2 = nums.poll();
                Character op = ops.poll();
                Integer res = null;
                if (p1 != null && p2 != null) {
                    if (op == '+') {
                        res = p1 + p2;
                    } else if (op == '-') {
                        res = p1 - p2;
                    }
                } else {
                    //多出来一个负数
                    if (op == '+') {
                        res = p1;
                    } else if (op == '-') {
                        res = -p1;
                    }
                }

                //todo 乘法
                nums.addFirst(res);
            }
            return new Res(nums.poll(), right);
        }

        private Integer getNumber(char[] c, int i, int last) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j <= last; j++) {
                sb.append(c[j]);
            }
            return Integer.parseInt(sb.toString());
        }


        private int isNumber(char[] c, int index) {
            //是不是数字，如果是数字就返回最后一个坐标的下标，不是就返回-1
            int last = -1;
            for (int i = index; i < c.length; i++) {
                char n = c[i];
                if (n >= '0' && n <= '9') {
                    last = i;
                } else {
                    break;
                }
            }
            return last;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 基本计算器().new Solution();
//        Solution.Res cal = solution.cal(new char[]{'1', '-', '2', '+', '3'}, 0);

//        int cal = solution.calculate("-2+ 1");
//        int cal = solution.calculate("- (3 + (4 + 5))");
        int cal = solution.calculate("1-(+1+1)");
//        int cal = solution.calculate("1-11");
        System.out.println(cal);
    }

}