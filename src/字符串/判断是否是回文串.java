package 字符串;

/**
 *给定一个字符串，确定它是否是回文，只考虑字母数字字符和忽略大小写。
 例如，
 "A man, a plan, a canal: Panama"是一个回文。
 "race a car"不是回文。
 注意：
 你认为字符串可能是空的吗？ 在采访中这是一个很好的问题。
 为了这个问题的目的，我们将空字符串定义为有效的回文。
 * Created by Tony on 2017/5/25.
 */
public class 判断是否是回文串 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0;
        int right = s.length()-1;
        while (left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            else if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            } else if (!(s.charAt(left) == s.charAt(right))) {
                return false;
            }else {
                left++;
                right--;
            }
        }
        return true;
    }
}
