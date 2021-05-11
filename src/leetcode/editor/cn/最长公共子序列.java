package leetcode.editor.cn;

/**
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 */
public class 最长公共子序列 {

    public static int longestCommonSubsequence(String text1, String text2) {
        // write code here
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (text2.charAt(j - 1) == text1.charAt(i - 1)) {
                    dp[i][j] = dp[i][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    private int[][] memo;

    public int longestCommonSubsequence2(String text1, String text2) {
        //递归的解法就是找出重复的子问题并用递归去扩大还原整个问题
        // a,b,c,d,e
        // a,c,e,f
        memo = new int[text1.length()][text2.length()];

        return dp(text1, 0, text2, 0);
    }

    /**
     * 用递归去解决问题的关键就是找到子问题。
     * 用备忘录去剪枝
     *
     * @param text1
     * @param i
     * @param text2
     * @param j
     * @return
     */
    public int dp(String text1, int i, String text2, int j) {
        //base case
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        int max;
        //选择，把所有的选择都列出来。这就是让计算机穷举，我们只需要去求解最大值即可。
        if (text1.charAt(i) == text2.charAt(j)) {
            //如果字符相等，就+1，并进入下一个子问题
            max = 1 + dp(text1, i + 1, text2, j + 1);
        } else {
            //如果字符串不相等，取两个子问题的最大值。
            max = Math.max(dp(text1, i + 1, text2, j), dp(text1, i, text2, j + 1));
        }
        memo[i][j] = max;
        return max;
    }
}
