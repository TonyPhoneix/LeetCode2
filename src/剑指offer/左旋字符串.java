package 剑指offer;

public class 左旋字符串 {
    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() == 0 || n <= 0) {
            return "";
        }
        String temp = str + str;
        return temp.substring(n, n + str.length() + 1);
    }
}
