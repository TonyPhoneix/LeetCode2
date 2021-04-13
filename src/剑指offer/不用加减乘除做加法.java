package 剑指offer;

public class 不用加减乘除做加法 {
    public int Add(int num1,int num2) {
        while (num2 != 0) {
            //计算和，不带进位
            int temp = num1 ^ num2;
            //计算进位
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }
        return num1;
    }
}
