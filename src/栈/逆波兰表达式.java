package 栈;

import java.util.Stack;

/**
 * 用反向波形符号评估算术表达式的值。
 * 有效运算符是+， - ，*，/。 每个操作数可以是整数或另一个表达式。
 * 一些例子：
 *    [“2”，“1”，“+”，“3”，“*”] - >（（2 + 1）* 3） - > 9
 *    [“4”，“13”，“5”，“/”，“+”] - >（4 +（13/5）） - > 6
 * Created by Tony on 2017/5/12.
 */
public class 逆波兰表达式 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            try {
                int value = Integer.parseInt(tokens[i]);
                stack.add(value);
            } catch (NumberFormatException e) {
                int x = stack.pop();
                int y = stack.pop();
                //这里要注意一下，如果是除法，先弹出的是被除数，后弹出的是除数
                int res = get(y,x, tokens[i]);
                stack.add(res);
            }
        }
        return stack.pop();
    }

    private int get(int x, int y, String token) {
        int res = 0;
        switch (token) {
            case "+":
                res = x + y;
                break;
            case "-":
                res = x - y;
                break;
            case "*":
                res = x * y;
                break;
            case "/":
                res = x / y;
                break;
            default:
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
