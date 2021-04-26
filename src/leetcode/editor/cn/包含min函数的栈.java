//定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push
// 及 pop 的时间复杂度都是 O(1)。
//
// 
//
// 示例: 
//
// MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.min();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.min();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// 各函数的调用总次数不超过 20000 次 
// 
//
// 
//
// 注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/ 
// Related Topics 栈 设计 
// 👍 124 👎 0

package leetcode.editor.cn;

import java.util.Stack;

/**
 * [剑指 Offer 30] 包含min函数的栈 </br>
 *
 * @see <a href="https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/">包含min函数的栈</a>
 * <p>
 * 思路：使用辅助栈每次记录最小值
 */
public class 包含min函数的栈 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {

        Stack<Integer> stack;
        Stack<Integer> minStack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            if (minStack.isEmpty()) {
                minStack.push(x);
            } else if (minStack.peek() > x) {
                //大于x，则push x
                minStack.push(x);
            } else {
                //小于x
                minStack.push(minStack.peek());
            }
            stack.push(x);
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.min();
     */
    //leetcode submit region end(Prohibit modification and deletion)
    public static void main(String[] args) {
        MinStack solution = new 包含min函数的栈().new MinStack();
    }

}