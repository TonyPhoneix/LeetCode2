package 动态规划;

/**
 * Created by huajian.yuan on 2017/8/22.
 */
public class 最长上升子序列 {

    public static int getLIS(int[] A, int n) {
        // write code here
        //dp[i]表示数组以i为下标的元素为结尾的最长上升子序列
        int[] dp = new int[n + 1];
        //以下标0结尾的数组的LIS
        dp[0] = 1;
        int top = 0;
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
//                    dp[i] = Math.max()
                    max = Math.max(max, dp[j]);
                }
                dp[i] = max + 1;
            }
            if (top < dp[i]) {
                top = dp[i];
            }
        }
        return top;
    }

    public static void main(String[] args) {

        int[] arr = {1, 4, 2, 5, 3};
        int lis = getLIS(arr, 5);
        System.out.println(lis);
    }

}
