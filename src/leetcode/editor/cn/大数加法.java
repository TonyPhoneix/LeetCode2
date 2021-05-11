package leetcode.editor.cn;

/**
 * 以字符串的形式读入两个数字，编写一个函数计算它们的和，以字符串形式返回。
 * （字符串长度不大于100000，保证字符串仅由'0'~'9'这10种字符组成）
 */
public class 大数加法 {


    /**
     * "1","99" 输出100
     * 其实就是模拟小学加法，从个位数 进行加法，有进制的话就累加到下一次。
     *
     * @param s
     * @param t
     * @return
     */
    public String solve(String s, String t) {
        // write code here
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = s.length() - 1, j = t.length() - 1; i >= 0 || j >= 0 || carry != 0; i--, j--) {
            int s1 = (i < s.length() && i >= 0) ? (s.charAt(i) - '0') : 0;
            int s2 = (j < t.length() && j >= 0) ? (t.charAt(j) - '0') : 0;
            int sum = s1 + s2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        return sb.reverse().toString();
    }
}
