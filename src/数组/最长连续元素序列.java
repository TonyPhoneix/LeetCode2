package 数组;

import java.util.HashSet;

/**
 * 给定一个未排序的整数数组，找出最长连续元素序列的长度。
 * 例如，
 * 给予[100,4,2200,1,3,2]
 * 连续元数最长的序列是[1,2,3,4]。 返回长度：4。
 * 您的算法应该以O（n）复杂度运行。
 * Created by Tony on 2017/5/25.
 */
public class 最长连续元素序列 {
    /**
     * 题解：
     * <p>
     * 这道题利用HashSet的唯一性解决，能使时间复杂度达到O(n)。首先先把所有num值放入HashSet，
     * 然后遍历整个数组，如果HashSet中存在该值，就先向下找到边界，找的同时把找到的值一个一个从set中删去，
     * 然后再向上找边界，同样要把找到的值都从set中删掉。所以每个元素最多会被遍历两边，时间复杂度为O(n)。
     *
     * @param num
     * @return
     */
    public int longestConsecutive(int[] num) {
        int max = 0;
        if (num == null || num.length == 0) {
            return max;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < num.length; i++) {
            set.add(num[i]);
        }

        //开始计数
        for (int i = 0; i < num.length; i++) {
            int count = 0;
            if (set.contains(num[i])) {
                set.remove(num[i]);
                count++;
            }

            int low = num[i] - 1;
            while (set.contains(low)) {
                set.remove(low);
                count++;
                low--;
            }
            int high = num[i] + 1;
            while (set.contains(high)) {
                set.remove(high);
                count++;
                high++;
            }
            max = Math.max(max, count);
        }
        return 0;
    }
}
