package 位操作;

/**
 * 给定整数数组，除了一个元素之外，每个元素都出现三次。 找到那个单一的。
 * 注意：
 * 您的算法应该具有线性运行时的复杂性。 你可以实现它而不使用额外的内存吗？
 * Created by Tony on 2017/5/17.
 */
public class 找出唯一的数2 {
    public int singleNumber(int[] A) {
        int one = 0, two = 0, three = 0;
        for (int i : A) {
            two |= (one & i);
            one ^= i;
            three = ~(one & two);
            one &= three;
            two &= three;
        }
        return one;
    }
}
