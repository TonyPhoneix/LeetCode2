package 美图;

import java.util.Scanner;

/**
 * Created by huajian.yuan on 2017/9/4.
 */
public class 计算不同为 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();

        int m = a ^ b;
        int num = 0;
        while(m>0)
        {
            m &= (m-1);
            num++;
        }
        System.out.println(num);
    }
}
