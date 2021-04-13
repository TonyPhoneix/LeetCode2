package 剑指offer;

import java.util.ArrayList;

public class 和为S的连续正数序列 {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        if (sum <= 0) {
            return res;
        }
        int start = 1, end = 2;
        while (start < end) {
            int cur = (start + end) * (end - start + 1) / 2;
            if (cur == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    list.add(i);
                }
                res.add(list);
                end++;
            } else if (cur < sum) {
                end++;
            } else {
                start++;
            }
        }
        return res;
    }
}
