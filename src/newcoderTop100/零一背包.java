package newcoderTop100;

/**
 * https://www.nowcoder.com/practice/2820ea076d144b30806e72de5e5d4bbf?tpId=190&tqId=38201&rp=1&ru=%2Fta%2Fjob-code-high-rd&qru=%2Fta%2Fjob-code-high-rd%2Fquestion-ranking&tab=answerKey
 */
public class 零一背包 {

    /**
     * @param V  体积V
     * @param n  个数N
     * @param vw 第一个物品的体积为1，重量为3，第二个物品的体积为10，重量为4。 v[i][0] = 体积，v[i][1] = 重量
     * @return
     */
    private int[][] memo; //memo 当容量为v时, 个数为i时 ，memo[v][i]能装的最大重量。

    public int knapsack(int V, int n, int[][] vw) {
        // write code here
        // 找到子问题，子问题是什么，一个物体是否应该放入背包，放入背包还是不放入背包，取最大值。
        // 分析子问题的所有情况，base case和其他case
        memo = new int[V + 1][n + 1];
        return dp(V, 1, vw);
    }

    /**
     * @param v  包的剩余体积
     * @param i  第i个物品 i从1开始
     * @param vw 物品的体积和重量
     * @return 重量
     */
    public int dp(int v, int i, int[][] vw) {
        if (i > vw.length) {
            return 0;
        }
        if (memo[v][i] != 0) {
            return memo[v][i];
        }
        //如果当前容量不够装，就只能装下一个了
        if (v < vw[i - 1][0]) {
            return dp(v, i + 1, vw);
        }
        //假设够装的话，有两种选择，一个是装，一个是不装
        //假设i放入背包
        int max;
        int include = vw[i - 1][1] + dp(v - vw[i - 1][0], i + 1, vw);
        //假设i不放入背包
        int noInclude = dp(v, i + 1, vw);
        max = Math.max(include, noInclude);
        memo[v][i] = max;
        return max;
    }
}
