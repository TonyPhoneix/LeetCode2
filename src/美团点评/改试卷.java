package 美团点评;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by huajian.yuan on 2017/8/31.
 */
public class 改试卷 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        Arrays.sort(arr);
        if (arr[n-1] == arr[n-2]){
            System.out.println("yes");
        }else {
            int count = 0;
            for (int i = 0; i < n - 1; i++) {
                count += arr[i];
            }
            if (count < arr[n-1]) {
                System.out.println("yes");
            }else {
                System.out.println("No");
            }
        }

    }
}
