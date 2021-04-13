package 网易;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by huajian.yuan on 2017/8/12.
 */
public class 数组操作 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int i = s.nextInt();
        long[] arr = new long[i];
        for (int j = 0; j < arr.length; j++) {
            arr[j] = s.nextInt();
        }

        ArrayList list = new ArrayList();
        for (int j = 0; j < arr.length; j++) {
            list.add(arr[j]);
            Collections.reverse(list);
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < list.size(); j++) {
            sb.append(list.get(j));
            if (j != list.size() - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}
