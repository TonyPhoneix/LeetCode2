package 动态规划;

/**
 * 给定两个字符串A和B，返回两个字符串的最长公共子序列的长度。例如，A="1A2C3D4B56”，B="B1D23CA45B6A”，”123456"或者"12C4B6"都是最长公共子序列。
 * <p>
 * 给定两个字符串A和B，同时给定两个串的长度n和m，请返回最长公共子序列的长度。保证两串长度均小于等于300。
 * <p>
 * 测试样例：
 * "1A2C3D4B56",10,"B1D23CA45B6A",12
 * 返回：6           
 * Created by huajian.yuan on 2017/8/21.
 */
public class 最长公共子序列 {
    public static int findLCS(String A, int n, String B, int m) {
        // write code here
        //dp[i][j]表示长度为i的A串和长度为j的B串的最长公共子序列长度
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i <=n; i++) {
            //初始值， 当B为空串的时候，dp[i][0] = 0
            dp[i][0] = 0;
        }
        //当A为空串的时候
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <n; i++) {
            for (int j = 1; j <m ; j++) {
                if (A.charAt(i) == B.charAt(j)){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
       return dp[n][m];
    }

    public static void main(String[] args) {
        System.out.println(findLCS("zynnqufc",8,"ddbauhkw",8));
    }
}
