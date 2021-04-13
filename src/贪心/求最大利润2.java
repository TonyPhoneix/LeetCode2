package 贪心;

/**
 * 说你有一个数组，第i个元素是第i天给定股票的价格。
 * 设计一个算法来找到最大的利润。
 * 您可以根据需要完成尽可能多的交易（即，购买一次并多次出售股票）。
 * 但是，您可能不会同时从事多个交易（即，您必须在再次购买之前先出售该股票）。
 * Created by Tony on 2017/6/6.
 */
public class 求最大利润2 {
    /**
     * 简单的方法就是一旦第二天的价格比前一天的高，就在前一天买入第二天卖出。代码如下：
     * <p>
     * 但是这个会违反“不能同一天买卖的规则”，例如3天的价格分别为1，2，3，那么按上述算法就会在2那天同一天买卖了。。。
     * <p>
     * 正确的做法是： 第1天买第3天卖。
     * <p>
     * 虽然两种方法数字结果是对的，但是逻辑不一样。。
     * <p>
     * 不过虽然这么说，这道题的本事仍然是让你找最大利润，并没有让你明确哪天买哪天卖。
     * <p>
     * 所以对面试官你仍然可以说，这种方法只是帮助我找到最大利润，我并没有说是要在同一天买卖，只是计算：所有第二天比前一天大的差值的合，我是为了找最大利润而已（画个趋势图讲解一下就行了。。）。
     * <p>
     * <p>
     * <p>
     * 不过如果不是那样略有点投机取巧的话，干嘛非要每一次有一点点增长就加总和，带来不必要的解释麻烦？
     * <p>
     * 何不先找到递减的局部最低点，再找到递增的局部最高点，算一次加和，然后再这么找？ 这样就能保证买卖不会在同一天了。。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int total = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                total += (prices[i] - prices[i - 1]);
            }
        }
        return total;
    }


    /**
     * 找到最低点买入，最高点卖出，循环这个过程。
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len <= 1)
            return 0;

        int i = 0;
        int total = 0;
        while (i < len - 1) {
            int buy, sell;
            //寻找递减区间的最后一个值（局部最小点）
            while (i + 1 < len && prices[i + 1] < prices[i])
                i++;
            //局部最小点作为买入点
            buy = i;

            //找下一个点(卖出点至少为下一个点）
            i++;
            //不满足。。继续往下找递增区间的最后一个值（局部最高点）
            while (i < len && prices[i] >= prices[i - 1])
                i++;
            //设置卖出点
            sell = i - 1;
            //计算总和
            total += prices[sell] - prices[buy];
        }
        return total;
    }
}
