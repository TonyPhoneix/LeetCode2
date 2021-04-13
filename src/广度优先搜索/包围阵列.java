package 广度优先搜索;

import java.util.LinkedList;

/**
 * 给定一个包含'X'和'O'的2D板，捕获被'X'包围的所有区域。
 * 如果O被X包围，则替换O为X。
 * 例如，
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * <p>
 * 运行功能后，主板应该是：
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * Created by Tony on 2017/5/24.
 */
public class 包围阵列 {

    /**
     * 思路:
     * 这道题是说一个O周围都是X那么这个O就得变成X。
     * 那么就可以发现四周这一圈如果有O肯定不能四周都被X包围，同时这个O也将会是潜在的内部的O的缺口，
     * 让内部的O不能都被X覆盖。因此，思路就是先对四周的O进行特殊处理，
     * 用BFS走，把所有这个O连接的O（包括这个O）都涂成#。这样子，对于原来的棋盘来说，
     * 没有变成#的O就是四周没有被O污染的，四周都是X，那么对其变成X。
     * 而所有#就是那些原来是O但是不是四周都被X包围的，把它们再还原成O。
     *
     * @param board
     */
    public void solve(char[][] board) {
        if (board == null || board.length <= 1 || board[0].length <= 1) {
            return;
        }


        //填充第一行和最后一行
        for (int i = 0; i < board[0].length; i++) {
            fill(board, 0, i);
            fill(board, board.length - 1, i);
        }
        //填充第一列和最后一列
        for (int i = 0; i < board.length; i++) {
            fill(board, i, 0);
            fill(board, i, board[0].length - 1);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }


    public void fill(char[][] board, int i, int j) {
        //如果不等于O,就返回
        int n = board[0].length;
        if (board[i][j] != 'O') {
            return;
        }
        //等于O就替换
        board[i][j] = '#';

        LinkedList<Integer> list = new LinkedList<>();
        int code = n * i + j;
        list.add(code);
        while (!list.isEmpty()) {
            int node = list.poll();
            int col = node % n; //还原坐标
            int row = node / n;
            //判断点上面是否有O
            if (row >= 1 && board[row - 1][col] == 'O') {
                code = (row - 1) * n + col;
                list.add(code);
                board[row - 1][col] = '#';
            }
            //判断点下面是否有O
            if (row < board.length - 1 && board[row + 1][col] == 'O') {
                code = (row + 1) * n + col;
                list.add(code);
                board[row + 1][col] = '#';
            }
            //判断点左边是否有O
            if (col >= 1 && board[row][col - 1] == 'O') {
                code = (row) * n + col - 1;
                list.add(code);
                board[row][col - 1] = '#';
            }
            //判断点右边是否有O
            if (col <= n - 2 && board[row][col + 1] == 'O') {
                code = (row) * n + col + 1;
                list.add(code);
                board[row][col + 1] = '#';
            }
        }
    }

    public static void main(String[] args) {
        char[][] arr = {{'X', 'O', 'X', 'O','X'}, {'X', 'O', 'X', 'O','X'}, {'X', 'O', 'X', 'O','X'}, {'X', 'O', 'X', 'O','X'}};
        包围阵列 test = new 包围阵列();
        test.solve(arr);

    }
}
