package 动态规划;

/**
 * 7
 * 3   8
 * 8   1   0
 * 2   7   4   4
 * 4   5   2   6   5
 * 要求输出最大和
 * <p>
 * 在上面的数字三角形中寻找一条从顶部到底边的路径，使得路径上所经过的数字之和最大。
 * 路径上的每一步都只能往左下或 右下走。只需要求出这个最大和即可，不必给出具体路径。
 * 三角形的行数大于1小于等于100，数字为 0 - 99
 * Created by Tony on 2017/5/17.
 */
public class 数字三角形 {

    public static void main(String[] args) {
        int[][] arr = new int[5][5];
        arr[0][0] = 7;
        arr[1] = new int[]{3, 8};
        arr[2] = new int[]{8, 1, 0};
        arr[3] = new int[]{2, 7, 4, 4};
        arr[4] = new int[]{4, 6, 2, 6, 5};

        //解：
        int length = 5;
        int[][] dp = new int[5][5];
        //边界条件，直接赋值
        dp[4] = arr[4];


        for (int i = 3; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]) + arr[i][j];
            }
        }

        System.out.println(dp[0][0]);

    }
}
