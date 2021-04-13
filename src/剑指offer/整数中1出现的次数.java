package 剑指offer;

public class 整数中1出现的次数 {
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n <= 0) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int temp = i;
            while (temp != 0) {
                if (temp % 10 == 1) {
                    count++;
                }
                temp /= 10;
            }
        }
        return count;
    }
}
