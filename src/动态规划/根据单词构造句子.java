package 动态规划;

import java.util.Set;

/**
 * 给定一个字符串s和一个词dict的字典，确定s可以被分割成一个或多个字典单词的空格分隔的序列。
 * 例如，给定
 * s =“leetcode”，
 * dict = [“leet”，“code”]。
 * 返回true，因为“leetcode”可以被分割为“leet code”。
 * Created by Tony on 2017/5/17.
 */
public class 根据单词构造句子 {
    /**
     * 设状态为f(i)，表示s[0,i)是否可以分词，则状态转移方程为
     * f(i) = any_of(f(j) && s[j,i] in dict), 0 <= j < i
     *
     * @param s
     * @param dict
     * @return
     */
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] dp = new boolean[s.length() + 1];
        //表示空字符串是否可以被分割
        dp[0] = true;
        //这里i是<=字符串总长度的，为什么呢，因为substring(j,i)是包含j不包含i的，假如i = s.length()
        // 那么dp[s.length]表示的是从0到dp[s.length-1]是可以分割的。
        for (int i = 0; i <= s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                //如果从上个分割点到i是被包含在set里的话，就dp[i]=true;表示可以分割。
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
