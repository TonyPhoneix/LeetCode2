package 动态规划;

/**
 * Created by huajian.yuan on 2017/8/22.
 */
public class 零一背包 {

    public int maxValue(int[] w, int[] v, int n, int cap) {
        // write code here
        //dp[i][j] 表示 i 件物品为j的重量的价值
        int[][] dp = new int[n + 1][cap + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= cap; j++) {
                if (j >= w[i - 1]) {
                    //说明可以装,
                    dp[i][j] = Math.max(dp[i - 1][j - w[i - 1]] + v[i - 1], dp[i - 1][j]);
                } else {
                    //说明没有空间可以装了
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][cap];
    }
}
