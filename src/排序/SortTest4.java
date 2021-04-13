package 排序;

public class SortTest4 extends BaseSort {

    public static void main(String[] args) {
        var arrays = getRandomArrays();
        printArr(arrays);
        selectSort(arrays);
        bubbleSort(arrays);
//        bubbleSort2(arrays);
        insertSort(arrays);
//        insertSort2(arrays);
        mergeSort(arrays, 0, arrays.length - 1);
//        quickSort(arrays, 0, arrays.length - 1);
//        quickSort2(arrays, 0, arrays.length - 1);
//        heapSort(arrays);
        heapSort2(arrays);
        printArr(arrays);
    }

    private static void heapSort2(int[] arrays) {
        //构造大顶堆, 堆顶值最大，然后替换就可以了。
        int n = arrays.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heap2(arrays, i, n - 1);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(arrays, 0, i);
            heap2(arrays, 0, i - 1);

        }
    }

    private static void heap2(int[] arrays, int start, int end) {
        int c = start;
        int l = c * 2 + 1;
        int temp = arrays[c];
        for (; l <= end; c = l, l = l * 2 + 1) {
            if (l < end && arrays[l] < arrays[l + 1]) {
                l++;
            }
            if (temp > arrays[l]) {
                break;
            }
            arrays[c] = arrays[l];
            arrays[l] = temp;
        }
    }

    private static void heapSort(int[] arrays) {
        //先从 2/n -1 进行构造大顶推
        int n = arrays.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heap(arrays, i, n - 1);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(arrays, 0, i);
            heap(arrays, 0, i - 1);
        }
    }

    private static void heap(int[] arrays, int start, int end) {
        int c = start;
        int l = c * 2 + 1;
        int temp = arrays[c];
        for (; l <= end; c = l, l = l * 2 + 1) {
            if (l < end && arrays[l] < arrays[l + 1]) {
                l++;
            }
            if (temp > arrays[l]) {
                break;
            }
            arrays[c] = arrays[l];
            arrays[l] = temp;
        }
    }

    private static void quickSort2(int[] arrays, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start;
        int j = end;
        int k = arrays[i];
        while (i < j) {
            while (i < j && arrays[j] > k) {
                j--;
            }
            if (i < j) {
                arrays[i++] = arrays[j];
            }
            while (i < j && arrays[i] < k) {
                i++;
            }
            if (i < j) {
                arrays[j--] = arrays[i];
            }
        }
        arrays[i] = k;
        quickSort2(arrays, start, i - 1);
        quickSort2(arrays, i + 1, end);
    }

    private static void quickSort(int[] arrays, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start;
        int j = end;
        int k = arrays[i];
        while (i < j) {
            while (i < j && arrays[j] > k) {
                //找到小于k的
                j--;
            }
            if (i < j) {
                //交换
                arrays[i++] = arrays[j];
            }
            while (i < j && arrays[i] < k) {
                //找到大于k的
                i++;
            }
            if (i < j) {
                //交换
                arrays[j--] = arrays[i];
            }
        }
        arrays[i] = k;
        quickSort(arrays, start, i - 1);
        quickSort(arrays, i + 1, end);
    }

    private static void mergeSort(int[] arrays, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(arrays, start, mid);
        mergeSort(arrays, mid + 1, end);
        merge(arrays, start, mid, end);
    }

    //两个数组合并成一个数组啦，start -> mid 是一个数组， mid+ 1 -> end又是一个数组
    private static void merge(int[] arrays, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (arrays[i] < arrays[j]) {
                temp[k++] = arrays[i++];
            } else {
                temp[k++] = arrays[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arrays[i++];
        }
        while (j <= end) {
            temp[k++] = arrays[j++];
        }

        for (int l = 0; l < k; l++) {
            arrays[start + l] = temp[l];
        }
    }

    private static void insertSort2(int[] arrays) {
        //构架有序数组，然后挨个遍历后续的元素，从有序数组中找到合适的位置并插入
        for (int i = 1; i < arrays.length; i++) {
            int j = i;
            int temp = arrays[j];
            for (; j > 0 && temp < arrays[j - 1]; j--) {
                arrays[j] = arrays[j - 1];
            }
            arrays[j] = temp;

        }
    }

    private static void insertSort(int[] arrays) {
        //插入排序，构建有序数组，然后遍历到下一个指定的元素与相邻元素进行比较，如果小的话，就挪，直到找到大于的元素，循环结束，并插入
        for (int i = 1; i < arrays.length; i++) {
            int j = i;
            int temp = arrays[j];
            for (; j > 0 && temp < arrays[j - 1]; j--) {
                //挪位置
                arrays[j] = arrays[j - 1];
            }
            arrays[j] = temp;
        }
    }

    private static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            //记录最小的index，然后从后面的数字中取出更小的index，通过遍历的方式不断更新
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            swap(array, i, min);
        }
    }

    private static void bubbleSort(int[] array) {
        //冒泡排序，大值会不停的交换直到交换到数组的最后
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    private static void bubbleSort2(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }
}
