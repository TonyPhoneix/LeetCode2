package 剑指offer;

public class 连续子数组的最大和 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int res = array[0];
        int cur = array[0];
        for (int i = 1; i < array.length; i++) {
            cur = Math.max(cur + array[i], array[i]);
            res = Math.max(cur, res);
        }
        return res;
    }
}
