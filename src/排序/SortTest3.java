package 排序;

public class SortTest3 extends BaseSort {
    public static void main(String[] args) {
        int[] arr = getRandomArrays();
        printArr(arr);
        //选择排序
//        selectSort(arr);
        //冒泡
//        bubbleSort(arr);
        //插入
//        insertSort(arr);
        //归并
//        mergeSort(arr, 0, arr.length - 1);
        //快速
        quickSort(arr, 0, arr.length - 1);
        //堆排
//        heapSort(arr);
        printArr(arr);
    }

    private static void heapSort(int[] arr) {
        //构造大顶对
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heap(arr, i, n - 1);
        }

        //交换第一值到末尾
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            heap(arr, 0, i - 1);
        }
    }

    private static void heap(int[] arr, int start, int end) {
        int c = start;
        int temp = arr[c];
        int l = 2 * c + 1;
        for (; l <= end; c = l, l = 2 * l + 1) {
            if (l < end && arr[l + 1] > arr[l]) {
                l++;
            }
            if (temp > arr[l]) {
                break;
            }
            arr[c] = arr[l];
            arr[l] = temp;
        }
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        //k是基准值
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
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= end) {
            temp[k++] = arr[j++];
        }
        for (int l = 0; l < k; l++) {
            arr[start + l] = temp[l];
        }
    }

    private static void insertSort2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int tmp = arr[j];
            for (; j > 0 && tmp < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = tmp;
        }
    }

    private static void insertSort(int[] arr) {
        //把元素插入到左侧有序数组里
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int temp = arr[i];
            for (; j > 0 && temp < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    private static void bubbleSort2(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void selectSort(int[] arr) {
        //每次循环，寻找最小值
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            swap(arr, min, i);
        }
    }
}
