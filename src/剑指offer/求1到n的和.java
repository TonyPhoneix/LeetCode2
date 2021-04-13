package 剑指offer;

public class 求1到n的和 {
    public int Sum_Solution(int n) {
        if (n == 1) {
            return n;
        }
        return n + Sum_Solution(n - 1);
    }
}
