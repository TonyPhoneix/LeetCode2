package newcoder;

/**
 * 给定一个数组arr，返回子数组的最大累加和
 * 例如，arr = [1, -2, 3, 5, -2, 6, -1]，所有子数组中，[3, 5, -2, 6]可以累加出最大的和12，所以返回12.
 * 题目保证没有全为负数的数据
 * [要求]
 * 时间复杂度为O(n)O(n)，空间复杂度为O(1)O(1)
 */
public class 子数组的最大累加和问题 {

    /**
     * 思路：累加求和
     * 底线是0，累加的和不能小于0,小于0就放弃，大于0则继续累加
     * max记录累加过程中最大的值
     *
     * @param arr
     * @return
     */
    public int maxsumofSubarray(int[] arr) {
        // write code here
        int max = 0, cur = 0;
        //max 记录最大值，cur是加上当前值，
        //[1, -2, 3, 5, -2, 6, -1]  = 12   3,5,-2,6
        for (int i = 0; i < arr.length; i++) {
            cur += arr[i];
            max = Math.max(cur, max);
            cur = Math.max(cur, 0);
        }
        return max;
    }
}
