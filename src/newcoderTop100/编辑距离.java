package newcoderTop100;

import java.util.stream.IntStream;

/**
 * 给你两个单词word1 和word2，请你计算出将word1转换成word2 所使用的最少操作数。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 编辑距离 extends Base {

    Integer[][] memo;

    /**
     * 输入：word1 = "horse", word2 = "ros"
     * 输出：3
     * 解释：
     * horse -> rorse (将 'h' 替换为 'r')
     * rorse -> rose (删除 'r')
     * rose -> ros (删除 'e')
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance2(String word1, String word2) {
        memo = new Integer[word1.length()][word2.length()];
        return dp2(0, word1, 0, word2, "开始操作");
    }

    /**
     * 状态dp(i,j)表示，0~i, 0~j 的最小替换操作数
     * 选择，如果word1[i] = word[j]，就 跳过，看下一个。
     * 如果不相等，则对当前字符有三个操作
     * 1、删除 i+1, j
     * 2、插入 i,j+1
     * 3、替换 i+1, j+1
     *
     * @param i     word1从i开始
     * @param word1
     * @param j     word2 从j开始
     * @param word2
     * @return
     */
    public int dp2(int i, String word1, int j, String word2, String operation) {
        print(count++, "i = " + i + " j = " + j + "操作: " + operation);
        if (i == word1.length()) {
            print(--count, "return " + (word2.length() - j));
            return word2.length() - j;
        }
        if (j == word2.length()) {
            print(--count, "return " + (word1.length() - i));
            return word1.length() - i;
        }
        if (memo[i][j] != null) {
            print(--count, "return " + memo[i][j]);
            return memo[i][j];
        }

        int min;
        var c = word1.charAt(i);
        var c1 = word2.charAt(j);
        if (c == c1) {
            min = dp2(i + 1, word1, j + 1, word2, "跳过 " + c + " 和 " + c1);
        } else {
            var replaceCount = dp2(i + 1, word1, j + 1, word2, "替换 " + c + " 和 " + c1);
            var deleteCount = dp2(i + 1, word1, j, word2, "删除 " + c);
            var insertCount = dp2(i, word1, j + 1, word2, "插入 " + c1);
            min = IntStream.of(replaceCount, deleteCount, insertCount).min().getAsInt() + 1;
        }
        print(--count, "return " + min);
        memo[i][j] = min;
        return min;
    }

    public static void main(String[] args) {
        编辑距离 c = new 编辑距离();
        c.minDistance2("bb", "a");
    }


    public int minDistance(String word1, String word2) {
        memo = new Integer[word1.length()][word2.length()];
        return dp(0, word1, 0, word2);
    }

    public int dp(int i, String word1, int j, String word2) {
        //base case
        if (i == word1.length()) {
            //如果word1遍历到头了，那就返回剩下的操作数，等于插入串
            return word2.length() - j;
        }
        if (j == word2.length()) {
            //如果Word2到头了，就返回剩下的操作数，等于删除剩下的串
            return word1.length() - i;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        int min;
        var c = word1.charAt(i);
        var c1 = word2.charAt(j);
        if (c == c1) {
            //如果两个字符串相等，则遍历下一个
            min = dp(i + 1, word1, j + 1, word2);
        } else {
            //操作3选1
            //如果是替换，就遍历下一个，操作数+1
            var replaceCount = dp(i + 1, word1, j + 1, word2);
            //如果删除i，那就跳到下一个字符继续比较，操作数+1，j仍然不动
            var deleteCount = dp(i + 1, word1, j, word2);
            //如果是在i串上插入=j的字符，那i不动，j遍历到下一位。
            var insertCount = dp(i, word1, j + 1, word2);
            min = IntStream.of(replaceCount, deleteCount, insertCount).min().getAsInt() + 1;
        }
        memo[i][j] = min;
        return min;
    }
}
