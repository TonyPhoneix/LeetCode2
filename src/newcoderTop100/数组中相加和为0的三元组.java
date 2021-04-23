package newcoderTop100;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * https://www.nowcoder.com/practice/345e2ed5f81d4017bbb8cc6055b0b711
 * 给出一个有n个元素的数组S，S中是否有元素a,b,c满足a+b+c=0？找出数组S中所有满足条件的三元组。
 * 注意：
 * 三元组（a、b、c）中的元素必须按非降序排列。（即a≤b≤c）
 * 解集中不能包含重复的三元组。
 * <p>
 * 例如，给定的数组 S = {-40,-10,-10,0,10,20},解集为(-10, 0, 10) (-10, -10, 20)
 */
public class 数组中相加和为0的三元组 {

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> total = new ArrayList<>();
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            //遍历每个元素，然后确定left & right
            int target = -num[i];
            int left = i + 1;
            int right = num.length - 1;
            while (left < right) {
                int result = num[left] + num[right];
                if (result < target) {
                    //说明负数较大，所以left++
                    left++;
                } else if (result > target) {
                    //说明正数较大，所以right--
                    right--;
                } else {
                    //说明三个元素正好可以凑出0
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(num[i]);
                    list.add(num[left]);
                    list.add(num[right]);
                    if (!total.contains(list)) {
                        total.add(list);
                    }
                    left++;
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        数组中相加和为0的三元组 c = new 数组中相加和为0的三元组();
        ArrayList<ArrayList<Integer>> arrayLists = c.threeSum(new int[]{-2, 0, 1, 1, 2});
        System.out.println(arrayLists);
    }
}
