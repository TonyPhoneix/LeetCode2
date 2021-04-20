package newcoderTop100;

/**
 * https://www.nowcoder.com/practice/f33f5adc55f444baa0e0ca87ad8a6aac?tpId=190&tqId=36002&rp=1&ru=%2Fta%2Fjob-code-high-rd&qru=%2Fta%2Fjob-code-high-rd%2Fquestion-ranking&tab=answerKey
 * 给定两个字符串str1和str2,输出两个字符串的最长公共子串
 * 题目保证str1和str2的最长公共子串存在且唯一。
 * <p>
 * "1AB2345CD","12345EF"
 * <p>
 * "2345"
 */
public class 最长公共子串 {

    public String LCS(String str1, String str2) {
        // write code here
        int max = 0;
        String str = null;
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                int dp = dp(i, str1, j, str2);
                if (max < dp) {
                    max = dp;
                    str = str1.substring(i + 1 - max, i + 1);
                }
            }
        }
        return str;
    }


    /**
     * 状态：以0~i结尾的字符串，和以0~j结尾的字符串的长度
     * 选择， str[i] == str[j] 比较str[i-1] str[j-1] 否则，return0；
     *
     * @param i
     * @param str1
     * @param j
     * @param str2
     * @return
     */
    public int dp(int i, String str1, int j, String str2) {
        //base case
        if (i < 0 || j < 0) {
            return 0;
        }

        //选择
        if (str1.charAt(i) == str2.charAt(j)) {
            return dp(i - 1, str1, j - 1, str2) + 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        最长公共子串 c = new 最长公共子串();
        c.LCS("2LQ74WK8Ld0x7d8FP8l61pD7Wsz1E9xOMp920hM948eGjL9Kb5KJt80", "U08U29zzuodz16CBZ8xfpmmn5SKD80smJbK83F2T37JRqYfE76vh6hrE451uFQ100ye9hog1Y52LDk0L52SuD948eGjLz0htzd5YF9J1Y6oI7562z4T2");
    }
}
