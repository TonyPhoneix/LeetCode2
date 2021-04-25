package Top100;

/**
 * https://www.nowcoder.com/practice/7cd13986c79d4d3a8d928d490db5d707
 * 给出一个转动过的有序数组，你事先不知道该数组转动了多少
 * (例如,0 1 2 4 5 6 7可能变为4 5 6 7 0 1 2).
 * 在数组中搜索给出的目标值，如果能在数组中找到，返回它的索引，否则返回-1。
 * 假设数组中不存在重复项。
 */
public class 在转动过的有序数组中寻找目标值 {

    /**
     * 局部有序，二分法
     *
     * @param A
     * @param target
     * @return
     */
    public int search(int[] A, int target) {
        // write code here
        return search(A, 0, A.length - 1, target);
    }

    /**
     * 思路，二分法，
     * 指定mid后， 要么start-mid是有序的，要么mid 到end是有序的，如果有序的话，就可以二分查找，如果不是有序组里的就继续分
     *
     * @param A
     * @param start
     * @param end
     * @param target
     * @return
     */
    public int search(int[] A, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        int mid = (end + start) / 2;
        if (A[mid] == target) {
            return mid;
        } else if (A[start] <= A[mid]) {
            //则start-mid是有序的。
            if (target < A[mid] && target >= A[start]) {
                //如果mid> target && target >= start
                //那就再start 到 mid中继续找
                return search(A, start, mid - 1, target);
            } else {
                //mid < target
                //说明
                return search(A, mid + 1, end, target);
            }
        } else {
            //说明 mid 到 end 是有序的, start - mid 是无序的
            if (target > A[mid] && target <= A[end]) {
                //mid < target && target <= end
                //说明 在mid+1到end里找
                return search(A, mid + 1, end, target);
            } else {
                //如果mid> target
                //那就再start 到 mid中继续找
                return search(A, start, mid - 1, target);
            }
        }
    }

    public static void main(String[] args) {
        在转动过的有序数组中寻找目标值 c = new 在转动过的有序数组中寻找目标值();
        int search = c.search(new int[]{3, 1}, 1);
        System.out.println(search);
    }
}
