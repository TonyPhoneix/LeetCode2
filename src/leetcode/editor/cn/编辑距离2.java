package leetcode.editor.cn;

/**
 * 给定两个字符串str1和str2，再给定三个整数ic，dc和rc，分别代表插入、删除和替换一个字符的代价，请输出将str1编辑成str2的最小代价。
 * 链接：https://www.nowcoder.com/practice/05fed41805ae4394ab6607d0d745c8e4
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 编辑距离2 {

    Integer[][] memo;

    public int minEditCost(String str1, String str2, int ic, int dc, int rc) {
        // write code here
        memo = new Integer[str1.length()][str2.length()];
        return dp(str1, 0, str2, 0, ic, dc, rc);
    }

    /**
     * 子问题是啥：对于单个字符，有两种可能，一种是相等，则跳过，一种是不相等，则需要操作
     * 操作有三种，1、删除，2、插入、3、替换，选择成本最小的一种。
     * <p>
     * 状态 dp[i][j] 表示0-i的字符串a 转换到 0-j 的字符串b的最小成本
     * 选择：如果 a[i] =a[j]，则跳过，i++,j++。如果 不相等，则进行操作。
     * 删除：i++,j表示a的字符删除，a串走到下一个字符
     * 插入：i， j++ 表示插入与b字符相同的字符，b串走到下一个字符
     * 替换，i++,j++ 表示替换，a和b都走到下一个字符
     * <p>
     * 如果，a串先走完，b未走完，则需要执行b串剩余字符的插入动作
     * 如果 b串先走完，a串未走完，执行a串剩余字符的删除操作。
     *
     * @param ic 插入
     * @param dc 删除
     * @param rc 替换
     * @return
     */
    public int dp(String str1, int i, String str2, int j, int ic, int dc, int rc) {


        if (i == str1.length() && j == str2.length()) {
            //都遍历完了，则结束操作
            return 0;
        } else if (i == str1.length() && j < str2.length()) {
            //执行插入操作
            return (str2.length() - j) * ic;
        } else if (i < str1.length() && j == str2.length()) {
            //执行删除操作
            return (str1.length() - i) * dc;
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        if (str1.charAt(i) == str2.charAt(j)) {
            //字符相等，跳过到下一个
            int dp = dp(str1, i + 1, str2, j + 1, ic, dc, rc);
            memo[i][j] = dp;
            return dp;
        } else {
            //插入字符
            int iv = dp(str1, i, str2, j + 1, ic, dc, rc) + ic;
            //删除
            int dv = dp(str1, i + 1, str2, j, ic, dc, rc) + dc;
            //替换
            int rv = dp(str1, i + 1, str2, j + 1, ic, dc, rc) + rc;
            int min = Math.min(Math.min(iv, dv), rv);
            memo[i][j] = min;
            return min;
        }
    }

    public static void main(String[] args) {
        编辑距离2 c = new 编辑距离2();
        int i = c.minEditCost("abcd", "adc", 5, 3, 2);
        System.out.println(i);
    }
}
