package Top100;

import java.util.HashMap;

/**
 * 给出一个整数数组，请在数组中找出两个加起来等于目标值的数，
 * 你给出的函数twoSum 需要返回这两个数字的下标（index1，index2），需要满足 index1 小于index2.。注意：下标是从1开始的
 * 假设给出的数组中只存在唯一解
 * 例如：
 * 给出的数组为 {20, 70, 110, 150},目标值为90
 * 输出 index1=1, index2=2
 */
public class 两数之和 {

    /**
     * 思路，用hashmap去记录值和下标，然后遍历数组，判断 target - x 是否存在，如果存在，就可以返回，不存在就将x加入hashmap
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        // write code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int j = target - numbers[i];
            if (map.containsKey(j)) {
                return new int[]{map.get(j), j};
            }
            map.put(numbers[i], i);
        }
        return new int[]{};
    }
}
