package cvte;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by huajian.yuan on 2017/9/2.
 */
public class 幼儿园 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int idx = 1;

        StringBuilder sb = new StringBuilder();
        while (list.size() > 1) {
            sb.append(idx+" ");
            for (int i = 0; i < m-1; i++) {
                idx = (idx + 1) % list.size();
            }
            list.remove(idx);
        }
        sb.append(list.get(0));
        System.out.println(sb.toString());
    }
}
