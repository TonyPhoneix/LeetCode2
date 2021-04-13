package 排序;

import java.util.Random;

public class BaseSort {

    public static int[] getRandomArrays() {
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(200);
        }
        return arr;
    }

    /**
     * 打印 数组
     *
     * @param arr
     */
    public static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


    /**
     * 交换数组中的两个值
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
