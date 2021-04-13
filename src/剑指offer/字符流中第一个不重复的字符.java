package 剑指offer;

public class 字符流中第一个不重复的字符 {
    int[] chars = new int[256];
    StringBuilder sb = new StringBuilder();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if (ch > 255) {
            throw new IllegalArgumentException(ch + "must be a ASCII char");
        }
        sb.append(ch);
        chars[ch]++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char[] chars = sb.toString().toCharArray();
        for (char aChar : chars) {
            if (chars[aChar] == 1) {
                return aChar;
            }
        }
        return '#';
    }
}
