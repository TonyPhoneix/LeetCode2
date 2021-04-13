package 剑指offer;

import java.util.ArrayList;
import java.util.List;

public class 有多少个1 {
    public static List<Integer> getOneBits(int n) {
        // Write your code here
        List<Integer> list = new ArrayList<>();

        list.add(Integer.bitCount(n));
        String bitStr = Integer.toBinaryString(n);
        char[] chars = bitStr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                list.add(i + 1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> oneBits = getOneBits(161);
        System.out.println(oneBits);
    }
}
