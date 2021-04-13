package 美团点评;

import java.util.Scanner;

/**
 * Created by huajian.yuan on 2017/8/31.
 */
public class K的倍数 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        int k = s.nextInt();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (n - i + 1 >= count) {
                break;
            }
            int sum = 0;
            int temp = 0;
            for (int j = i; j < n; j++) {
                temp++;
                sum += arr[j];
                if (sum % k == 0) {
                    count = Math.max(count, temp);
                }
            }
        }
        System.out.println(count);

    }
}
