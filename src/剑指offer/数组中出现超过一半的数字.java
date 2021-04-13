package 剑指offer;

public class 数组中出现超过一半的数字 {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int times = 1;
        int res = array[0];
        for (int i = 1; i < array.length; i++) {
            if (times == 0) {
                res = array[i];
                times++;
            }
            if (array[i] != res) {
                times--;
            }else {
                times++;
            }
        }

        times = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == res) {
                times++;
            }
        }
        return times > (array.length / 2) ? res : 0;
    }
}
