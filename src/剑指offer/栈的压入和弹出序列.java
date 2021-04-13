package 剑指offer;

import java.util.Stack;

public class 栈的压入和弹出序列 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || popA == null) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
}
