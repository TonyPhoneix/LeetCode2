package 排序;

import java.util.Random;

/**
 * Created by Tony on 2017/5/14.
 */
public class SortTest {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(200);
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        // selectSort(arr);
        // bubbleSort(arr);
//         insertSort(arr);
        // shellSort(arr);
        // quickSort(arr, 0, arr.length - 1);
        // mergeSort(arr, 0, arr.length - 1);
//         heapSort(arr, arr.length);
        // heapSort2(arr, arr.length);
//        jishuSort(arr, 3);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void jishuSort(int[] arr, int d) {
        // TODO Auto-generated method stub
        int n = 1;
        int m = 1;
        int k = 0;
        int[][] temp = new int[10][arr.length];
        int[] order = new int[10];
        while (m <= d) {
            for (int i = 0; i < arr.length; i++) {
                int lsd = (arr[i] / n) % 10;
                temp[lsd][order[lsd]++] = arr[i];
            }

            for (int i = 0; i < 10; i++) {
                if (order[i] != 0) {
                    for (int j = 0; j < order[i]; j++) {
                        arr[k++] = temp[i][j];
                    }
                }
                order[i] = 0;
            }

            m++;
            n *= 10;
            k = 0;
        }

    }

    private static void heapSort2(int[] arr, int length) {
        // TODO Auto-generated method stub
        int i, temp;
        for (i = length / 2 - 1; i >= 0; i--) {
            heap2(arr, i, length - 1);
        }
        for (i = length - 1; i >= 0; i--) {
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heap2(arr, 0, i - 1);
        }
    }

    public static void heap2(int[] arr, int start, int end) {
        int c = start;
        int l = c * 2 + 1;
        int temp = arr[c];
        for (; l <= end; c = l, l = l * 2 + 1) {
            if (l < end && arr[l] < arr[l + 1]) {
                l++;
            }
            if (temp > arr[l]) {
                break;
            } else {
                arr[c] = arr[l];
                arr[l] = temp;
            }
        }
    }

    private static void heapSort(int[] arr, int length) {
        // TODO Auto-generated method stub
        for (int i = length / 2 - 1; i >= 0; i--) {
            heap(arr, i, length - 1);
        }

        int temp;
        for (int i = length - 1; i >= 0; i--) {
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            //置换0下标的数，对0下标的数进行重新堆排序，只调整0下标
            heap(arr, 0, i - 1);
        }
    }

    private static void heap(int[] arr, int start, int end) {
        int c = start;
        int l = c * 2 + 1;
        int temp = arr[c];
        for (; l <= end; c = l, l = l * 2 + 1) {
            if (l < end && arr[l] < arr[l + 1]) {
                l++;
            }
            // 如果当前节点的值大于子节点，那么跳出循环
            if (temp > arr[l]) {
                break;
            } else {
                arr[c] = arr[l];
                arr[l] = temp;
            }
        }
    }

    private static void mergeSort(int[] arr, int start, int end) {
        // TODO Auto-generated method stub
        if (arr == null || start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);

    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int[] tmp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            tmp[k++] = arr[i++];
        }

        while (j <= end) {
            tmp[k++] = arr[j++];
        }

        // 合并
        for (i = 0; i < k; i++) {
            arr[start + i] = tmp[i];
        }

        tmp = null;
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;
            int k = arr[i];
            while (i < j) {
                // 从后面找一个比k小的数
                while (i < j && k < arr[j])
                    j--;
                if (i < j) {
                    arr[i] = arr[j];
                    i++;
                }

                while (i < j && k > arr[i])
                    i++;
                if (i < j) {
                    arr[j] = arr[i];
                    j--;
                }
            }
            arr[i] = k;

            quickSort(arr, left, i - 1);
            quickSort(arr, i + 1, right);
        }
    }

    private static void shellSort(int[] arr) {
        int n = 1;
        while (n < arr.length / 3) {
            n = n * 3 + 1;
        }

        while (n > 0) {
            for (int i = n; i < arr.length; i++) {
                int j = i;
                int temp = arr[i];
                for (; j > n - 1 && temp < arr[j - n]; j -= n) {
                    arr[j] = arr[j - n];
                }
                arr[j] = temp;
            }

            n = (n - 1) / 3;
        }
    }

    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int temp = arr[j];
            for (; j > 0 && temp < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }

    }

    private static void selectSort(int[] arr) {
        // TODO Auto-generated method stub
        for (int i = 0; i < arr.length - 1; i++) {
            int k = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[k] > arr[j]) {
                    k = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;
        }
    }

    private static void bubbleSort(int[] arr) {
        // TODO Auto-generated method stub
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }
}
