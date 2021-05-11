package leetcode.editor.cn;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class 跳台阶 {

    /**
     * 其实是斐波那契数列
     * 1级台阶有1种跳法
     * 2级台阶有2种跳法
     * 3级台阶有3种跳法
     * n级台阶有 f(n-1) + f(n-2)的跳法
     * @param target
     * @return
     */
    public int jumpFloor(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return jumpFloor(target - 1) + jumpFloor(target - 2);
    }

    public int jumpFloor2(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int first = 1;
        int second = 2;
        int total = 0;
        for (int i = 3; i <= target; i++) {
            total = first + second;
            first = second;
            second = total;
        }
        return total;
    }
}
