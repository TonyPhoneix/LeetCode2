package 剑指offer;

public class 斐波那契数列 {
    //递归版本
    public int Fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    //动态规划
    public int Fibonacci2(int n) {
        if (n <= 1) {
            return n;
        }
        int[] temp = new int[n + 1];
        temp[1] = 1;
        for (int i = 2; i <= n; i++) {
            temp[i] = temp[i - 1] + temp[i - 2];
        }
        return temp[n];
    }

    //遍历版本
    public int Fibonacci3(int n) {
        if (n <= 1) {
            return n;
        }
        int temp1 = 0;
        int temp2 = 1;
        int total = 0;
        for (int i = 2; i <= n; i++) {
            total = temp1 + temp2;
            temp1 = temp2;
            temp2 = total;
        }
        return total;
    }
}
