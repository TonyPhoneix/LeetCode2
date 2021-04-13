package 剑指offer;

public class 翻转单词序列 {
    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        //整体翻转单词
        char[] chars = str.toCharArray();
        reverse(chars, 0, chars.length - 1);
        int left = 0;
        int right = 0;
        while (right <= chars.length) {
            if (right==chars.length || chars[right] == ' ') {
                reverse(chars, left, right - 1);
                left = right + 1;
            }
            right++;
        }
        return new String(chars);
    }

    private void reverse(char[] chars, int left, int right) {
        if (chars == null || chars.length == 0 || left >= right) {
            return;
        }
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
