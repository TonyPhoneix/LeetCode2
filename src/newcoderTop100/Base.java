package newcoderTop100;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Base {

    int count;

    public void print(int n, String s) {
        for (int i = 0; i < n; i++) {
            System.out.print("    ");
        }
        System.out.print(s);
        System.out.println();
    }

    public int[][] toMatrix(String template) {
        //[1,2],[2,3],[3,4],[3,5],[4,5],[5,5],[5,6],[6,7],[7,8]
        var row = template.replace("[", "").split("]");
        var col = row[0].split(",");
        int[][] matrix = new int[row.length][col.length];
        for (int i = 0; i < row.length; i++) {
            var colStr = row[i];
            var split = colStr.split(",");
            var list = Arrays.stream(split).filter(this::isNotBlank).map(Integer::parseInt).collect(Collectors.toList());
            matrix[i][0] = list.get(0);
            matrix[i][1] = list.get(1);
        }
        return matrix;
    }

    private boolean isNotBlank(String s) {
        return s != null && s.length() != 0;
    }
}
