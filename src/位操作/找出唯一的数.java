package 位操作;

/**
 * 给定整数数组，除了一个元素之外，每个元素都会出现两次。 找到那个单一的
 * <p>
 * 注意：您的算法应具有线性运行时复杂度。 你可以实现它而不使用额外的内存吗？
 * Created by Tony on 2017/5/17.
 */
public class 找出唯一的数 {
    public int singleNumber(int[] A) {
        int x = 0;
        for (int i :
                A) {
            x^=i;
        }
        return x;
    }
}
