package 剑指offer;

public class 第一个只出现一次的字符 {
    public int FirstNotRepeatingChar(String str) {
        int[] charArr = new int[256];
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            charArr[chars[i]]++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (charArr[chars[i]] == 1) {
                return i;
            }
        }
        return -1;
    }
}
