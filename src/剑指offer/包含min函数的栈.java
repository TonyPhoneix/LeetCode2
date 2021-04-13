package 剑指offer;

import java.util.Stack;

public class 包含min函数的栈 {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();


    public void push(int node) {
        if (stack.isEmpty()) {
            stack.push(node);
            minStack.push(0);
        }else {
            stack.push(node);
            if (node < stack.get(minStack.peek())) {
                minStack.push(stack.size() - 1);
            }else {
                minStack.push(minStack.peek());
            }
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return stack.get(minStack.peek());
    }
}
