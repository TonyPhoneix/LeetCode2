package 动态规划;

/**
 * 说你有一个数组，第i个元素是第i天给定股票的价格。
 * <p>
 * 设计一个算法来找到最大的利润。 您最多可以完成两个交易。
 * <p>
 * 注意：
 * 您不可以同时进行多笔交易（例如，您必须在再次购买之前出售该股票）。
 * Created by Tony on 2017/6/8.
 */
public class 求最大利润3 {

    /**
     * 3比较难。允许2次买入卖出。在prices中，选取i，其中0到i买卖一次，i+1到len-1买卖一次，求出这两次买卖的利润，相加就是一次买卖的利润。
     * 从0到i次买卖一次，求最大利润，利用1的思路，可以直接求出来，但是这样会有很多重复计算。
     * 利用动态规划，声明两个数组arrayA，arrayB，其中arrayA[i]表示从0到i买卖一次的最大利润，arrayA[i]可根据arrayA[i-1]计算得到。
     * arrayB[i]表示从i到len-1买卖一次的最大利润，逆向思维来求解arrayB[i]，arrayB[i]可根据arrayB[i+1]计算得到。
     * 这样针对每个i，累加就可以得到最大利润。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int profit = 0;
        int min = prices[0];
        //arrayA[i]代表了0 到 i 的最大利润
        int[] arrayA = new int[prices.length];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            arrayA[i] = Math.max(arrayA[i - 1], prices[i] - min);
        }

        int max = prices[prices.length - 1];
        //arrayb[i]代表了i到prices.length-1的最大利润
        int[] arrayB = new int[prices.length];
        for (int i = prices.length - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            arrayB[i] = Math.max(arrayB[i + 1], max - prices[i]);
        }

        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, arrayB[i] + arrayA[i]);
        }
        return profit;
    }
}
