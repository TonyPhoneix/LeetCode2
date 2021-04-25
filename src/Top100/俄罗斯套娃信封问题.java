package Top100;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import common.*;

/**
 * https://leetcode-cn.com/problems/russian-doll-envelopes/
 * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
 * <p>
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * <p>
 * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * <p>
 * 注意：不允许旋转信封。
 */
public class 俄罗斯套娃信封问题 extends Base {

    int[] memo;

    public int maxEnvelopes(int[][] envelopes) {
        var list = Arrays.stream(envelopes)
                .sorted((o1, o2) -> Integer.compare(o1[0], o2[0]))
                .collect(Collectors.toList());
        memo = new int[list.size()];
        int max = 1;
        for (int i = 0; i < envelopes.length; i++) {
            max = Math.max(max, dp(i, list));
        }
        return max;
    }

    /**
     * 实际是找最长递增子序列的问题
     * //让数组先按照长度进行排序，然后长度相同，再按照高度排序
     * 状态：以0 ~ envelopes[i]结尾的信封个数
     * 选择：找到比envelopes[i]长度和宽度都小的元素 envelopes[j] + 1，否则，return 1
     *
     * @param i         0 ~ i
     * @param envelopes 高度 3,4,3,7,5
     *                  长度 2,2,4,5,5
     * @return 以envelopes[i]结尾的个数
     */
    public int dp(int i, List<int[]> envelopes) {
        //选择，从前面找到比i小的元素
        if (memo[i] != 0) {
            return memo[i];
        }
        int count = 1;
        for (int j = i - 1; j >= 0; j--) {
            if (envelopes.get(i)[0] > envelopes.get(j)[0] && envelopes.get(i)[1] > envelopes.get(j)[1]) {
                count = Math.max(count, dp(j, envelopes) + 1);
            }
        }
        memo[i] = count;
        return count;
    }

    public static void main(String[] args) {
        俄罗斯套娃信封问题 c = new 俄罗斯套娃信封问题();
        var i = c.maxEnvelopes(c.toMatrix("[1,2],[2,3],[3,4],[3,5],[4,5],[5,5],[5,6],[6,7],[7,8]"));
        System.out.println(i);
    }

}
