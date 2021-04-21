package newcoderTop100;

/**
 * 写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 * https://www.nowcoder.com/practice/c3a6afee325e472386a1c4eb1ef987f3
 */
public class 反转字符串 {

    public String solve(String str) {
        // write code here
        int start = 0, end = str.length() - 1;
        char[] chars = str.toCharArray();
        while (start <= end) {
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        反转字符串 c =new 反转字符串();
        System.out.println(c.solve("abc"));
    }
}
