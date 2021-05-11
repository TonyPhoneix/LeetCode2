package leetcode.editor.cn;

/**
 * 实现函数 int sqrt(int x).
 * 计算并返回x的平方根（向下取整
 * nowcoder.com/practice/09fbfb16140b40499951f55113f2166c
 */
public class 求平方根 {

    /**
     * 二分查找
     *
     * @param x
     * @return
     */
    public int sqrt(int x) {
        // write code here
        int sqrt = sqrt(x, 0, x);
        return sqrt * sqrt > x ? sqrt - 1 : sqrt;
    }

    public int sqrt(int x, int start, int end) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        if (start > end) {
            return start;
        }
        int mid = (start + end) / 2;
        long res = (long) mid * mid;
        if (res == x) {
            return mid;
        } else if (res < x) {
            //小于
            return sqrt(x, mid + 1, end);
        } else {
            //大于
            return sqrt(x, start, mid - 1);
        }
    }

    public static void main(String[] args) {
        求平方根 c = new 求平方根();
        int sqrt = c.sqrt(2147483647);
        System.out.println(sqrt);
    }
}
