package 剑指offer;

public class 调整数组顺序使奇数位于偶数前面 {
    public void reOrderArray(int [] array) {
        int[] arrJI = new int[array.length];
        int[] arrOu = new int[array.length];
        int m = 0;
        int n = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                arrOu[n++] = array[i];
            }else {
                arrJI[m++] = array[i];
            }
        }
        for (int i = 0; i < m; i++) {
            array[i] = arrJI[i];
        }
        for (int i = 0; i < n; i++) {
            array[m + i] = arrOu[i];
        }
    }
}
