package 剑指offer;

public class 二进制中1的个数 {
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0){
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
