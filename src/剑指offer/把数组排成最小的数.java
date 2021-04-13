package 剑指offer;

import java.util.Arrays;

public class 把数组排成最小的数 {
    public String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        String[] res = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            res[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(res, (o1, o2) -> {
            String t1 = o1 + o2;
            String t2 = o2 + o1;
            return t1.compareTo(t2);
        });
        StringBuilder sb = new StringBuilder();
        for (String re : res) {
            sb.append(re);
        }
        return sb.toString();
    }
}
