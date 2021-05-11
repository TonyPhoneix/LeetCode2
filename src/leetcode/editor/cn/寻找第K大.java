package leetcode.editor.cn;

/**
 * 有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
 * <p>
 * 给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。
 */
public class 寻找第K大 {
    /**
     * 思路，理由快排的分区性质，去找K大数，首先这个数组得是从大到小的，这样才是第K大。
     * 然后，分区之后，判断index是否就是第K大，如果小于第K，那么需要在数组右侧继续找。如果大于第K，则需要在左数组继续找，直到找到
     *
     * @param a
     * @param n
     * @param K
     * @return
     */
    public int findKth(int[] a, int n, int K) {
        return findKth(a, 0, n - 1, K);
    }

    public int findKth(int[] a, int start, int end, int K) {
        int index = partition(a, start, end);
        if (index + 1 < K) {
            //中轴小于K，需要在右边数组找
            return findKth(a, index + 1, end, K);
        } else if (index + 1 > K) {
            //中轴大于K，需要在左边数组找
            return findKth(a, start, index - 1, K);
        } else {
            return a[index];
        }
    }

    public int partition(int[] a, int start, int end) {
        int i = start;
        int j = end;
        int temp = a[i];
        while (i < j) {
            while (i < j && a[j] < temp) {
                j--;
            }
            if (i < j) {
                a[i++] = a[j];
            }
            while (i < j && a[i] > temp) {
                i++;
            }
            if (i < j) {
                a[j--] = a[i];
            }
        }
        a[i] = temp;
        return i;
    }
}
