package Top100;
import common.*;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 */
public class 最长回文子串 extends Base {

    Boolean[][] memo;

    public String longestPalindrome2(String s) {
        String max = "";
        if (s.length() == 1) {
            return s;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            var p1 = palindrome(i, i, s);
            var p2 = palindrome(i, i + 1, s);
            if (p1 != null && p1.length() > max.length()) {
                max = p1;
            }
            if (p2 != null && p2.length() > max.length()) {
                max = p2;
            }
        }
        return max;
    }

    public String palindrome(int l, int r, String s) {
        int i = l, j = r;
        if (s.charAt(i) != s.charAt(j)) {
            return null;
        }
        while (i >= 0 && j <= s.length() - 1) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }
        return s.substring(i + 1, j);
    }

    /**
     * 动态规划解法。
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        memo = new Boolean[s.length()][s.length()];

        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < s.length(); i++) {
            memo[i][i] = true;
        }
        int maxI = 0;
        int maxJ = 0;
        int temp = 0;
        for (int L = 2; L <= s.length(); L++) {
            for (int i = 0; i < s.length(); i++) {
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= s.length()) {
                    break;
                }
                if (dp(i, j, s.toCharArray()) && j - i + 1 > temp) {
                    maxI = i;
                    maxJ = j;
                    temp = j - i + 1;
                }
            }
        }

        return s.substring(maxI, maxJ + 1);
    }

    /**
     * 思路
     * 状态: i ,j  i表示起始位置，j表示终止位置，i<j ,dp[i][j]表示ij是不是回文串。
     * 返回 是否为回文串
     * 子问题：aba是不是子串，是，如果i = j 的话，那就看一下i-1是不是也是子串。
     * 选择，i=j，那么去判断i+1 j-1，是的话就+1
     *
     * @param i   i~j是不是回文串
     * @param j
     * @param arr
     * @return
     */
    public boolean dp(int i, int j, char[] arr) {
//        print(count++, "i = " + i + " j = " + j);
        if (i >= j) {
            //aa 这种情况
//            print(--count, "i > j return true");
            return true;
        }

        if (memo[i][j] != null) {
//            print(--count, "return " + memo[i][j]);
            return memo[i][j];
        }
        memo[i][j] = arr[i] == arr[j] && dp(i + 1, j - 1, arr);
//        print(--count, "return " + memo[i][j]);
        return memo[i][j];
    }

    public static void main(String[] args) {
        最长回文子串 c = new 最长回文子串();
        //TODO 动态规划 时间复杂度超出要求。
//        var babad = c.longestPalindrome("kyyrjtdplseovzwjkykrjwhxquwxsfsorjiumvxjhjmgeueafubtonhlerrgsgohfosqssmizcuqryqomsipovhhodpfyudtusjhonlqabhxfahfcjqxyckycstcqwxvicwkjeuboerkmjshfgiglceycmycadpnvoeaurqatesivajoqdilynbcihnidbizwkuaoegmytopzdmvvoewvhebqzskseeubnretjgnmyjwwgcooytfojeuzcuyhsznbcaiqpwcyusyyywqmmvqzvvceylnuwcbxybhqpvjumzomnabrjgcfaabqmiotlfojnyuolostmtacbwmwlqdfkbfikusuqtupdwdrjwqmuudbcvtpieiwteqbeyfyqejglmxofdjksqmzeugwvuniaxdrunyunnqpbnfbgqemvamaxuhjbyzqmhalrprhnindrkbopwbwsjeqrmyqipnqvjqzpjalqyfvaavyhytetllzupxjwozdfpmjhjlrnitnjgapzrakcqahaqetwllaaiadalmxgvpawqpgecojxfvcgxsbrldktufdrogkogbltcezflyctklpqrjymqzyzmtlssnavzcquytcskcnjzzrytsvawkavzboncxlhqfiofuohehaygxidxsofhmhzygklliovnwqbwwiiyarxtoihvjkdrzqsnmhdtdlpckuayhtfyirnhkrhbrwkdymjrjklonyggqnxhfvtkqxoicakzsxmgczpwhpkzcntkcwhkdkxvfnjbvjjoumczjyvdgkfukfuldolqnauvoyhoheoqvpwoisniv");
        //还是要写出来另一种解法。
        System.out.println(c.longestPalindrome2("babad"));
    }
}
