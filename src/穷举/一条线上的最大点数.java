package 穷举;

/**
 * 给定2D平面上的n个点，找到位于同一直线上的最大点数
 * Created by Tony on 2017/5/13.
 */
public class 一条线上的最大点数 {

    static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    /**
     * 暴力枚举法。两点决定一条直线，n个点两两组合,​对每一条直线，判断n个点是否在该直线上，
     * 从而可以得到这条直线上的点的个数，选择最大的那条直线返回。复杂度O(n^3)。
     * @param points
     * @return
     */
    public int maxPoints(Point[] points) {
        if (points.length < 3) return points.length;
        int result = 0;

        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int sign = 0;
                int a = 0, b = 0, c = 0;
                if (points[i].x == points[j].x) sign = 1;
                else {
                    a = points[j].x - points[i].x;
                    b = points[j].y - points[i].y;
                    c = a * points[i].y - b * points[i].x;
                }
                int count = 0;
                for (int k = 0; k < points.length; k++) {
                    if ((0 == sign && a * points[k].y == c + b * points[k].x) ||
                            (1 == sign && points[k].x == points[j].x))
                        count++;
                }
                if (count > result) result = count;
            }
        }
        return result;
    }
}
