package 美图;

import java.util.Scanner;

/**
 * Created by huajian.yuan on 2017/9/4.
 */
public class 最长公共子串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        int max = 0;
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = i; j <= str1.length(); j++) {
                StringBuffer sBuffer = new StringBuffer(str1.substring(i - 1, i));
                StringBuffer sBuffer1 = new StringBuffer(str1.substring(i, j));
                sBuffer.append(sBuffer1);
                if (str2.contains(sBuffer)) {
                    if (sBuffer.length() >= max) {
                        max = sBuffer.length();
                    }
                }
            }
        }
        System.out.println(max);

    }
}
