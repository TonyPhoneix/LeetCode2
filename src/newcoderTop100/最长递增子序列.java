package newcoderTop100;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 */
public class 最长递增子序列 extends Base {

    int[] memo;

    public int lengthOfLIS(int[] nums) {
        memo = new int[nums.length];
        memo[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            dp(i, nums);
        }
        return Arrays.stream(memo).max().getAsInt();
    }


    /**
     * 子问题是啥，我需要知道n个数的最长递增子序列的话，我得需要知道n-1个最长递增子序列是啥。那第N个数怎样可以算入递增子序列中。
     * 状态是啥：以 i 数为结尾的子序列的最长递增数组长度
     * <p>
     * Tips: 这里i的定义非常重要，如果i是前i个数的最长递增子序列（如果这样定义的话，子序列可能包括i，也可能不包括i），这样i无法根据前者得出最长子序列，
     * 假设按定义 序列 [4,10,4,1,3,8,9]， 那i=3 的时候 长度为2[4,10]，i=4的时候，长度为2[4，10]  可以看出，能不能把i加到子序列里，得看是否大于10，但这样是错误的，
     * 序列是有多种的，实际上上述序列的最长递增序列应该是[1,3,8,9]，和[4,10]没有关系，所以前i个数的最长递增子序列这种定义是不能帮助我们解题的。
     * <p>
     * 正确的定义，以 i 下标的数字为结尾的子序列的最长递增数组长度
     * 那上述序列，即 i下标的数字能不能加到序列里，就看前面有没有比i下标小的数字，如果有，就+1，如果没有，就从i开始，为1.
     *
     * 选择：第i个数是否可以加入递增子序列。判断条件：0~i-1个数中有没有比i小的值，有就加+1，没有就从当前i为起点。
     *
     * 选择：正确的选择决定了程序的正确性。
     * <p>
     *
     * @param i
     * @return
     */
    public int dp(int i, int[] nums) {
        //base case 当只有一个数的时候，长度为1
        print(count++, "i = " + i);
        if (memo[i] != 0) {
            print(--count, "return " + memo[i]);
            return memo[i];
        }
        int max = 1;
        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                max = Math.max(memo[i], dp(j, nums) + 1);
            }
        }
        memo[i] = max;
        print(--count, "return " + memo[i]);
        return max;
    }

    public static void main(String[] args) {
        最长递增子序列 c = new 最长递增子序列();
        System.out.println(c.lengthOfLIS(new int[]{1, 6, 5, 6, 4}));
    }

}
