package newcoderTop100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://www.nowcoder.com/practice/b56799ebfd684fb394bd315e89324fb4?tpId=190&tags=&title=&diffculty=0&judgeStatus=0&rp=1&tab=answerKey
 * 给定一个数组arr，返回arr的最长无的重复子串的长度(无重复指的是所有数字都不相同)。
 * 输入 [2,3,4,5]
 * 返回 4
 */
public class 找到字符串的最长无重复字符子串 {

    /**
     * 暴力求解，就是把所有的子序列都取出来存入set中，判断是否有重复的，有就终端
     *
     * @param arr
     * @return
     */
    public int maxLength(int[] arr) {
        // write code here
        Set<Integer> dict = new HashSet<>();
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int temp = 0;
            for (int j = i; j < arr.length; j++) {
                if (dict.contains(arr[j])) {
                    break;
                } else {
                    dict.add(arr[j]);
                    temp++;
                }
            }
            max = Math.max(max, temp);
            dict.clear();
        }
        return max;
    }

    /**
     * 其实这题可以理解遇到重复的就将数组从重复的地方断开，然后从断开处重新开始计算。所以可以用start 和 end两个指针来做
     * <p>
     * 我理解的意思是找到以arr[end]结尾的最长子串，然后max保持最大长度，当某个数在之前出现过，
     * 这个时候就把子串的起点start往后推一个，但是有一种情况，比如1，2，3，4，3，5，1。到第二个3时
     * ，以后的子串起点start为4，到第二个1时，如果不取最大的start，按start = map.get(arr[end])+1
     * 算出起点start为2，显然以起点start=2，结尾end=1的子串234351有重复的，因此start要取最大的
     *
     * @param arr
     * @return
     */
    public int maxLength2(int[] arr) {
        // write code here
        //
        int start = 0;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                start = Math.max(start, map.get(arr[i]) + 1);
            }
            max = Math.max(max, i - start + 1);
            map.put(arr[i], i);
        }
        return max;
    }
}
