package 数组;

/**
 * 沿循环路线有N个加油站.gas[i]表示第i个加油站有gas[i]的天然气。
 * 你有一辆带有无限气罐的汽车，cost[i]表示从i站开到i+1站要花费的天然气。 您在其中一个加油站开始开一个空坦克。
 * 如果您可以绕循环一次，请返回起始加油站的索引，否则返回-1。
 * 注意：
 * 解决方案保证是独一无二的。
 * Created by Tony on 2017/5/22.
 */
public class 加油站 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //因为解决方案是独一无二的
        //total表示坦克在这个路线中的总消耗，如果小于0，说明不存在解。
        int total = 0;
        //sum标识当前坦克的消耗，如果小于0，说明不成立，则说明之前的路线不成立。
        int sum = 0;
        //index表示起始位置
        int index = -1;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (sum < 0) {
                sum = 0;
                index = i;
            }
        }
        return total >= 0 ? index + 1 : -1;
    }
}
