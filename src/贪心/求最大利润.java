package 贪心;

/**
 * 说你有一个数组，第i个元素是第i天给定股票的价格。
 * 如果只允许最多完成一个交易（即购买一个交易并且卖出一个股票），则设计一个算法来找到最大利润。
 * Created by Tony on 2017/6/1.
 */
public class 求最大利润 {
    /**
     * 在股票最低的时候买入，在股票最高的时候卖掉就是我们要的最大利润，买入一定在卖掉的前面。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            //min表示我们买入的最小价格。
            min = Math.min(min, prices[i]);
            //max表示差价最大的时候
            max = Math.max(max, prices[i] - min);
        }

        return max;
    }
}
