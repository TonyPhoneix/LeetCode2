package 剑指offer;

import java.util.ArrayList;

public class 最小的k个数 {
    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        if (input == null || input.length == 0 || k <= 0 || k > input.length) {

            return list;
        }

        for (int i = 0; i < k; i++) {
            int min = i;
            for (int j = i; j < input.length; j++) {
                if (input[j] < input[min]) {
                    min = j;
                }
            }
            int temp = input[min];
            input[min] = input[i];
            input[i] = temp;
            list.add(input[i]);
        }
        return list;

    }
}
