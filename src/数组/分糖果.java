package 数组;

import java.util.Arrays;

/**
 * 有N个孩子站在一条线上。 每个孩子都被分配一个评分值。
 * 你给这些孩子糖果有以下要求：
 * 每个孩子必须至少有一个糖果。
 * 具有较高评级的儿童比邻居获得更多的糖果。
 * 你必须给予的最低糖果是什么？
 * Created by Tony on 2017/5/17.
 */
public class 分糖果 {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }

        int[] count = new int[ratings.length];
        //至少有一个
        Arrays.fill(count, 1);
        //正向扫描一次 ,保证右边比左边大的多一个糖果
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i] < ratings[i + 1]) {
                count[i + 1] = count[i] + 1;
            }
        }

        int sum = 0;
        //反向扫描一次，保证左边比右边大的多一个糖果
        for (int i = ratings.length - 1; i > 0; i--) {
            sum += count[i];
            if (ratings[i] < ratings[i - 1] && count[i - 1] <= count[i]) {
                count[i - 1] = count[i] + 1;
            }
        }
        sum += count[0];
        return sum;
    }
}
