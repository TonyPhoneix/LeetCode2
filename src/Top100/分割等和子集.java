package Top100;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * [1, 5, 11, 5]
 * true
 * 数组可以分割成 [1, 5, 5] 和 [11].
 */
public class 分割等和子集 {

    Boolean[][] memo;

    /**
     * 思路 转化问题
     * 状态：第i个数字，容量为m
     * 给定容量m，取0 ~ n个-1数字，任意选择组合相加 = m ,其实看到任意组合，就是列出来所有的情况
     * 子问题是什么，当前容量为m，我取1个数，那我就需要在剩下的元素中，找m = m-num[i]的情况
     * 那如果我不取当前元素，我就需要在剩下的元素中找到m = m 的情况
     *
     * basecase，当m = 0 说明，是累加是OK的，如果小于0，累加是不OK的。
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int m = sum / 2;
        if (m * 2 != sum) {
            return false;
        }
        memo = new Boolean[m + 1][nums.length + 1];
        Arrays.fill(memo[0], false);
        for (int i = 0; i < memo.length; i++) {
            memo[i][0] = false;
        }
        return dp(m, 1, nums);
    }

    /**
     * @param m    剩余的容量m
     * @param i    第i个元素，我可以放也可以不放
     * @param nums 给定的元素
     * @return
     */
    public boolean dp(int m, int i, int[] nums) {
        if (m == 0) {
            return true;
        }
        if (m < 0 || i > nums.length) {
            //容量小于0，返回false
            return false;
        }
        if (memo[m][i] != null) {
            return memo[m][i];
        }
        //有容量。但是当前这个元素的值大于m，那就只能不放了。
        boolean flag;
        if (nums[i - 1] > m) {
            flag = dp(m, i + 1, nums);
        } else {
            //那当前这个i元素，我可以放，也可以不放。
            flag = dp(m - nums[i - 1], i + 1, nums) || dp(m, i + 1, nums);
        }
        memo[m][i] = flag;
        return flag;
    }

    public static void main(String[] args) {
        分割等和子集 c = new 分割等和子集();
        System.out.println(c.canPartition(new int[]{1, 2, 5}));
    }
}
