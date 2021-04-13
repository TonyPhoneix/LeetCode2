package 剑指offer;

import java.util.ArrayList;

public class 和为S的两个数字 {
    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        if (array == null || array.length == 0) {
            return list;
        }
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int total = array[start] + array[end];
            if (total == sum) {
                list.add(array[start]);
                list.add(array[end]);
                return list;
            } else if (total < sum) {
                start++;
            }else {
                end--;
            }
        }
        return list;
    }
}
