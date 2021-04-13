package 剑指offer;

/**
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * Created by huajian.yuan on 2017/9/4.
 */
public class 替换空格 {
    public String replaceSpace(StringBuffer str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                sb.append("%20");
            }else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
