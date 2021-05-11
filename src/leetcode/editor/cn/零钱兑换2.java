package leetcode.editor.cn;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/coin-change-2/
 * <p>
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 * <p>
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 */
public class 零钱兑换2 {

    Integer[][] memo;

    public int change(int amount, int[] coins) {
        memo = new Integer[amount + 1][coins.length + 1];
        Arrays.fill(memo[0], 0);
        for (int i = 0; i < memo.length; i++) {
            memo[i][0] = 0;
        }
        return dp(amount, 1, coins);
    }

    /**
     * 其实是一个完全背包问题，区别于01背包的是，元素是无限的，可以重复放入。求的是解法而非价值。1个子集就是1个解法。非法的子集是0解法。
     * <p>
     * 状态是啥，剩余金额，待定的第i个元素
     * 选择是啥，并且也可以放入，也可以不放入。容量不够肯定无法放入
     * basecase，余额为0，方式=1，说明这是一个解 ，余额小于0，方式等于0，需要跳过。
     *
     * @param amount
     * @param i      第i个元素，下标从1开始
     * @param coins
     * @return 返回几种方式
     */
    public int dp(int amount, int i, int[] coins) {
        if (amount == 0) {
            return 1;
        }
        if (amount < 0 || i > coins.length) {
            return 0;
        }
        if (memo[amount][i] != null) {
            return memo[amount][i];
        }
        int count;
        if (amount < coins[i - 1]) {
            //容量不够，只能跳过
            count = dp(amount, i + 1, coins);
        } else {
            //如果放入是1个解法，如果不放入也是1个解法，那就是两个解法。
            count = dp(amount - coins[i - 1], i, coins) + dp(amount, i + 1, coins);
        }
        memo[amount][i] = count;
        return count;
    }

    public static void main(String[] args) {
        零钱兑换2 c = new 零钱兑换2();
        c.change(5, new int[]{1, 2, 5});
    }

}
