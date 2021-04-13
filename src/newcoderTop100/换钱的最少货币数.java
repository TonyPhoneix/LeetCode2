package newcoderTop100;

/**
 * https://www.nowcoder.com/practice/3911a20b3f8743058214ceaa099eeb45?tpId=190&tqId=36067&rp=1&ru=%2Fta%2Fjob-code-high-rd&qru=%2Fta%2Fjob-code-high-rd%2Fquestion-ranking&tab=answerKey
 * 给定数组arr，arr中所有的值都为正整数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个aim，代表要找的钱数，求组成aim的最少货币数。
 * 如果无解，请返回-1.
 * 【要求】
 * 时间复杂度O(n \times aim)O(n×aim)，空间复杂度On。
 */
public class 换钱的最少货币数 {

    int count;

    public void print(int n, String s) {
        for (int i = 0; i < n; i++) {
            System.out.print("    ");
        }
        System.out.print(s);
        System.out.println();
    }


    int[] memo;

    public int minMoney(int[] arr, int aim) {
        memo = new int[aim + 1];
        return dp(arr, aim);
    }

    /**
     * 递归的解法，穷举所有的可能。找到最小的方式。
     * 找到子问题，列出所有的case
     *
     * @param arr
     * @param aim
     * @return
     */
    public int dp(int[] arr, int aim) {
//        print(count++, "余额 = " + aim);
        if (aim < 0) {
            //余额不够就跳过
//            print(--count, "余额不足，跳过");
            return -1;
        }
        if (aim == 0) {
//            print(--count, "余额用完");
            return 0;
        }
        if (memo[aim] != 0) {
//            print(--count, "使用硬币数量 =" + memo[aim] + "读缓存");
            return memo[aim];
        }
        //列出所有case
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
//            print(count, "使用钱币:" + arr[i] + "元");
            int i1 = dp(arr, aim - arr[i]);
            if (i1 == -1) continue;
            res = Math.min(res, i1 + 1);
        }
        //也有可能没有能用的硬币，返回-1，否则返回硬币数
        int i = res == Integer.MAX_VALUE ? -1 : res;
        memo[aim] = i;
//        print(--count, "使用硬币数量 = " + i);
        return i;
    }

    public static void main(String[] args) {
        换钱的最少货币数 test = new 换钱的最少货币数();
//        test.coinChange(new int[]{5, 2, 3}, 7);
    }
}
