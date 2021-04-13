package 剑指offer;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * Created by huajian.yuan on 2017/9/4.
 */
public class 二维数组的查找 {
    public boolean Find(int target, int [][] array) {
        int i = 0;
        int j = array.length - 1;
        while (i < array[0].length && j >= 0) {
            if (array[i][j] == target) {
                return true;
            } else if (array[i][j] > target) {
                j--;
            }else {
                i++;
            }
        }
        return false;
    }
}
