package Top100;

/**
 * https://www.nowcoder.com/practice/2cc32b88fff94d7e8fd458b8c7b25ec1?tpId=190&tqId=35410&rp=1&ru=%2Fta%2Fjob-code-high-rd&qru=%2Fta%2Fjob-code-high-rd%2Fquestion-ranking&tab=answerKey
 * 给定一个十进制数M，以及需要转换的进制数N。将十进制数M转化为N进制数
 */
public class 进制转换 {
    public String solve(int M, int N) {
        StringBuilder sb = new StringBuilder();
        boolean negativeNumber = M < 0;
        int res = Math.abs(M);
        while (res != 0) {
            int temp = res;
            res = res / N;
            int i = temp % N;
            if (i > 9) {
                sb.append((char) ('A' + (i - 10)));
            } else {
                sb.append(i);
            }
        }
        return sb.append(negativeNumber ? "-" : "").reverse().toString();
    }

    public static void main(String[] args) {
        进制转换 c = new 进制转换();
        String solve = c.solve(-4, 3);
        System.out.println(solve);
    }
}
