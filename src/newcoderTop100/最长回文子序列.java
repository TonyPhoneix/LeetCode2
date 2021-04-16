package newcoderTop100;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-subsequence/
 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 * <p>
 * 输入:
 * "bbbab"
 * 输出:
 * 4
 */
public class 最长回文子序列 {

    Integer[][] memo;

    public int longestPalindromeSubseq(String s) {
        memo = new Integer[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            memo[i][i] = 1;
        }
        return dp(0, s.length() - 1, s.toCharArray());
    }

    /**
     * 子问题：i到j的最长回文子序列。
     * 回文子序列是从一个字符串中去掉一些字符，就变成回文串。
     * 状态： i~j
     * 选择：如果s[i]=s[j] ，那么他已经是一个回文子序列了，那就看s[i+1][j-1]是否也是子序列
     * 如果 s[i]!=s[j]那么就看一下 s[i+1] [j] 或者s[i][j-1] 谁的子序列长度大
     * 返回：i~j 的最长回文子序列的长度。
     *
     * @param i
     * @param j
     * @param s
     * @return
     */
    public int dp(int i, int j, char[] s) {
        if (i > s.length || j < 0 || i > j) {
            return 0;
        }
        if (i == j) {
            return 1;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        int max;
        if (s[i] == s[j]) {
            max = dp(i + 1, j - 1, s) + 2;
        } else {
            max = Math.max(dp(i, j - 1, s), dp(i + 1, j, s));
        }
        memo[i][j] = max;
        return max;
    }

    public static void main(String[] args) {
        最长回文子序列 c = new 最长回文子序列();
        var bbbab = c.longestPalindromeSubseq("bbbab");
        System.out.println(bbbab);
    }
}
