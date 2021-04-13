package 排序;

import java.util.Random;

public class SortTest2 extends BaseSort {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(200);
        }

        printArr(arr);
        /*
         * 排序算法
         */
//        selectSort(arr);
//        bubbleSort(arr);
//        insertSort(arr);
//        mergeSort(arr, 0, arr.length - 1);
//        quickSort(arr, 0, arr.length - 1);
//        quickSort2(arr, 0, arr.length);
//        heapSort(arr);
        heapSort2(arr);
        printArr(arr);

    }

    private static void heapSort2(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heap2(arr, i, n - 1);
        }

        for (int i = n - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heap2(arr, 0, i - 1);
        }
    }

    private static void heap2(int[] arr, int start, int end) {
        int c = start;
        //右节点
        int l = c * 2 + 1;
        int tmp = arr[c];
        for (; l <= end; c = l, l = l * 2 + 1) {
            //看左右节点谁大
            if (l < end && arr[l] < arr[l + 1]) {
                l++;
            }
            //和父节点比大小
            if (tmp >= arr[l]) {
                break;
            }
            //如果大于父节点就交换，
            arr[c] = arr[l];
            arr[l] = tmp;
        }
    }

    /**
     * 利用大顶堆的特性，最上面的元素就是该堆中最大的元素，然后将该元素置换到末尾，再进行大顶堆的调整。
     * https://www.cnblogs.com/skywang12345/p/3602162.html#a1
     * @param arr
     */
    private static void heapSort(int[] arr) {
        //初始化一个大顶堆
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heap(arr, i, n - 1);
        }
        //构造好一个大顶堆后，第一个元素就是最大的元素
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heap(arr, 0, i - 1);
        }
    }

    /**
     * 调整堆元素
     *
     * @param arr
     * @param start
     * @param end
     */
    private static void heap(int[] arr, int start, int end) {
        int c = start; //当前节点的位置
        int l = 2 * c + 1; //左孩子位置
        int tmp = arr[c];
        for (; l <= end; c = l, l = 2 * c + 1) {
            if (l < end && arr[l] < arr[l + 1]) {
                l++;
            }
            if (tmp > arr[l]) {
                break;
            }
            arr[c] = arr[l];
            arr[l] = tmp;

        }
    }

    private static void quickSort2(int[] arr, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;
            int k = arr[i];
            while (i < j) {
                while (i < j && arr[j] > k) {
                    j--;
                }
                if (i < j) {
                    arr[i++] = arr[j];
                }

                while (i < j && arr[i] < k) {
                    i++;
                }
                if (i < j) {
                    arr[j--] = arr[i];
                }
            }
            arr[i] = k;
            quickSort2(arr, left, i - 1);
            quickSort2(arr, i + 1, right);
        }
    }

    /**
     * 快速排序的思想就是选定一个值，以这个值进行其他数组元素的交换，
     * 从队尾寻找小于这个元素的值，并交换到队头，然后从对头寻找比这个元素大的元素交换到队尾，直到最后没有可以交换的元素后，将这个元素插入中间，并且拆分数组再进行一次交换
     *
     * @param arr
     * @param left
     * @param right
     */
    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int l = left;
            int r = right;
            int k = arr[l];
            while (l < r) {
                //从队尾找到小于k的元素，并交换到队头，完事了r的位置就空了
                while (l < r && arr[r] > k) {
                    r--;
                }
                if (l < r) {
                    arr[l++] = arr[r];
                }
                //从队头找到大于k的元素并交换，并交换到队尾的r位置，r就有元素了，但l就空了，依次循环。
                while (l < r && arr[l] < k) {
                    l++;
                }
                if (l < r) {
                    arr[r--] = arr[l];
                }
            }
            arr[l] = k;

            //然后递归处理两边的数组
            quickSort(arr, left, l - 1);
            quickSort(arr, l + 1, right);
        }
    }

    /**
     * 归并排序的思路就是将大数组细分成有序小数组之间的排序，当小数组有序后，那么大数组也会变得有序
     *
     * @param arr
     * @param start
     * @param end
     */
    private static void mergeSort(int[] arr, int start, int end) {
        if (arr == null || start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        //建立临时数组
        int[] tmp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        //挨个比较，放入临时数组
        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }

        //将剩余元素放入临时数组
        while (i <= mid) {
            tmp[k++] = arr[i++];
        }

        while (j <= end) {
            tmp[k++] = arr[j++];
        }

        //将临时数组的元素放入原数组
        for (int l = 0; l < k; l++) {
            arr[start + l] = tmp[l];
        }
        tmp = null;
    }

    /**
     * 插入排序的思路是每次循环都将下一个元素插入到左侧有序数组里，插入的过程就是让其他元素右移，将当前值插入到对应的槽中
     *
     * @param arr
     */
    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int temp = arr[j];
            for (; j > 0 && temp < arr[j - 1]; j--) {
                swap(arr, j, j - 1);
            }
            arr[j] = temp;
        }
    }

    /**
     * 冒泡排序的思路就是一次循环中让最大的值依次交换到末尾
     *
     * @param arr
     */
    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }


    /**
     * 选择排序的思想就是每次循环中挑出一个最小值，进行排序
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int k = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[k]) {
                    //swap
                    k = j;
                }
            }
            swap(arr, i, k);
        }
    }
}
