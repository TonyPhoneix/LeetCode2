package newcoderTop100;

import java.util.Stack;

/**
 * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
 * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
 */
public class 括号序列 {

    /**
     * 思路，因为数据是对称的关系，最好的方式就是在遍历时用栈去push对应的元素，若不存在则弹栈与元素进行匹配。
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        // write code here
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ('(' == c) {
                stack.push(')');
            } else if ('{' == c) {
                stack.push('}');
            } else if ('[' == c) {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
