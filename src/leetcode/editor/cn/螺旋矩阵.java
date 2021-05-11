package leetcode.editor.cn;

import common.Utils;

import java.util.ArrayList;

/**
 * 给定一个m x n大小的矩阵（m行，n列），按螺旋的顺序返回矩阵中的所有元素。
 * https://www.nowcoder.com/practice/7edf70f2d29c4b599693dc3aaeea1d31
 */
public class 螺旋矩阵 {

    /**
     * 1 2 3
     * 4 5 6
     * 7 8 9
     * i = 0,0,0,1,2,2,2,1,1
     * j = 0,1,2,2,2,1,0,0,1
     *
     * @param matrix
     * @return
     */
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();

        if (matrix.length == 0) {
            return list;
        }

        int top = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;
        int left = 0;
        int i = 0, j = 0;

        while (j <= right) {
            //横向遍历
            while (j <= right) {
                list.add(matrix[top][j++]);
            }
            top++;
            i++;
            j--;
            //纵向遍历
            if (i > bottom) {
                break;
            }
            while (i <= bottom) {
                list.add(matrix[i++][right]);
            }
            right--;
            j--;
            i--;
            //逆横遍历
            if (j < left) {
                break;
            }
            while (j >= left) {
                list.add(matrix[bottom][j--]);
            }
            bottom--;
            i--;
            j++;
            //逆纵遍历
            if (i < top) {
                break;
            }
            while (i >= top) {
                list.add(matrix[i--][left]);
            }
            left++;
            i++;
            j++;
        }
        return list;
    }

    public static void main(String[] args) {
        螺旋矩阵 c = new 螺旋矩阵();
        var integers = c.spiralOrder(Utils.toMatrix("[7],[9],[6]"));
        System.out.println(integers);
    }
}
