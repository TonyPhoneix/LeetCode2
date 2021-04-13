package 模拟;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Tony on 2017/6/8.
 */
public class 杨辉三角 {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }
        //添加第一行
        res.add(new ArrayList<>(Arrays.asList(1)));

        for (int i = 2; i <= numRows; i++) {
            Integer[] array = new Integer[i];
            //填充1
            Arrays.fill(array, 1);
            ArrayList<Integer> prev = res.get(i - 2);
            //第二行因为不满足条件所以跳过，这里是从第三行开始循环。
            for (int j = 1; j < i - 1; j++) {
                array[j] = prev.get(j - 1) + prev.get(j);
            }
            res.add(new ArrayList(Arrays.asList(array)));
        }
        return res;
    }
}
