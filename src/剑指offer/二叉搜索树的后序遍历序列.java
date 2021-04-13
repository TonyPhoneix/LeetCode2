package 剑指offer;

import java.util.Collections;

public class 二叉搜索树的后序遍历序列 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return judge(sequence, 0, sequence.length - 1);
    }

    private boolean judge(int[] sequence, int left, int right) {
        if (left >= right) {
            return true;
        }
        int i = right - 1;
        while (i >= left && sequence[i] > sequence[right]) {
            i--;
        }
        for (int j = left; j <= i; j++) {
            if (sequence[j] > sequence[right]) {
                return false;
            }
        }
        return judge(sequence, left, i) && judge(sequence, i + 1, right - 1);
    }
}
