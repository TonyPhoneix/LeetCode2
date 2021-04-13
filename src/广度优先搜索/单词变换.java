package 广度优先搜索;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * 给定两个字（开始和结束）和一个字典，从头到尾找到最短变换序列的长度，使得：
 * 一次只能改变一个字母
 * 每个中间词必须存在于字典中
 * 例如，
 * 鉴于：
 * 开始=“hit”
 * end =“cog”
 * dict = [“hot”，“dot”，“dog”，“lot”，“log”]
 * 作为一个最短的转换是"hit" -> "hot" -> "dot" -> "dog" -> "cog"
 * 返回长度5。
 * 注意：
 * 如果没有这样的转换序列，返回0。
 * 所有的词都有相同的长度。
 * 所有单词只包含小写字母字符。
 * Created by Tony on 2017/5/25.
 */
public class 单词变换 {
    /**
     * 这道题是套用BFS同时也利用BFS能寻找最短路径的特性来解决问题。
     * 把每个单词作为一个node进行BFS。当取得当前字符串时，对他的每一位字符进行从a~z的替换，如果在字典里面，
     * 就入队，并将下层count++，并且为了避免环路，需把在字典里检测到的单词从字典里删除。这样对于当前字符串的每一位字符安装a~z替换后，
     * 在queue中的单词就作为下一层需要遍历的单词了。
     * 正因为BFS能够把一层所有可能性都遍历了，所以就保证了一旦找到一个单词equals（end），那么return的路径肯定是最短的。
     * 像给的例子 start = hit，end = cog，dict = [hot, dot, dog, lot, log]
     * 按照上述解题思路的走法就是：
     * level = 1    hit   dict = [hot, dot, dog, lot, log]
     * ait bit cit ... xit yit zit ，  hat hbt hct ... hot ... hxt hyt hzt ，  hia hib hic ... hix hiy hiz
     * level = 2    hot  dict = [dot, dog, lot, log]
     * aot bot cot dot ...  lot ... xot yot zot，hat hbt hct ... hxt hyt hzt，hoa hob hoc ... hox hoy hoz
     * level = 3    dot lot  dict = [dog log]
     * aot bot ... yot zot，dat dbt ...dyt dzt，doa dob ... dog .. doy doz，
     * aot bot ... yot zot，lat lbt ... lyt lzt，loa lob ... log... loy loz
     * level = 4   dog log dict = []
     * aog bog cog
     * level = 5   cog  dict = []
     * 代码如下：
     *
     * @param start
     * @param end
     * @param dict
     * @return
     */
    public int ladderLength(String start, String end, HashSet<String> dict) {
        if (start == null || end == null || dict == null || dict.size() == 0) {
            return 0;
        }
        int level = 1;//初始化为1
        int lastNum = 1;//lastNum表示上一层还有几个结点
        int curNum = 0;//curNum表示当前一层有几个结点,当lastNum是0的时候，说明上一层结点已经遍历结束了~ 所以把curNum赋给lastNum因为进入下一层了哈~
        LinkedList<String> list = new LinkedList<>();
        list.add(start);
        while (!list.isEmpty()) {
            String s = list.poll();
            lastNum--;
            for (int i = 0; i < s.length(); i++) {
                char[] arr = s.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    arr[i] = j;
                    String temp = new String(arr);
                    if (temp.equals(end)) {
                        return level + 1;
                    }
                    if (dict.contains(temp)) {
                        list.add(temp);
                        curNum++;
                        dict.remove(temp);
                    }
                }
            }
            if (lastNum == 0) {
                lastNum = curNum;
                curNum = 0;
                level++;
            }
        }
        return 0;
    }
}
