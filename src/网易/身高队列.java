package 网易;

import java.util.Scanner;

/**
 * Created by huajian.yuan on 2017/8/12.
 */
public class 身高队列 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int len = s.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = s.nextInt();
        }

        //dp[i] 表示 i 个同学的最大疯狂值
        int[] dp = new int[len + 1];
        //说明
        dp[0] = 0;
    }
}
