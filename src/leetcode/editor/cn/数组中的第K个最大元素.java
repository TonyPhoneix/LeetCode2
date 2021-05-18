//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 1076 👎 0

package leetcode.editor.cn;

/**
 * [215] 数组中的第K个最大元素 </br>
 *
 * @see <a href="https://leetcode-cn.com/problems/kth-largest-element-in-an-array/">数组中的第K个最大元素</a>
 */
public class 数组中的第K个最大元素 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            return findKth(nums, 0, nums.length - 1, k);
        }

        //每一次的partition都能确定一个值的下标，通过这个思想
        public int findKth(int[] a, int start, int end, int K) {
            int index = partition(a, start, end);
            if (index + 1 < K) {
                //中轴小于K，需要在右边数组找
                return findKth(a, index + 1, end, K);
            } else if (index + 1 > K) {
                //中轴大于K，需要在左边数组找
                return findKth(a, start, index - 1, K);
            } else {
                return a[index];
            }
        }

        public int partition(int[] a, int start, int end) {
            int i = start;
            int j = end;
            int temp = a[i];
            while (i < j) {
                while (i < j && a[j] < temp) {
                    j--;
                }
                if (i < j) {
                    a[i++] = a[j];
                }
                while (i < j && a[i] > temp) {
                    i++;
                }
                if (i < j) {
                    a[j--] = a[i];
                }
            }
            a[i] = temp;
            return i;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 数组中的第K个最大元素().new Solution();
    }

}