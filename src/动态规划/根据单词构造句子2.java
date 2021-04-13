package 动态规划;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串s和一个单词dict的字典，在s中添加空格来构造一个句子，其中每个单词都是有效的字典单词。
 * 返回所有这样的句子。
 * 例如，给定
 * s =“catsanddog”，
 * dict = [“cat”，“cats”，“and”，“sand”，“dog”]。
 * 解决方案是[“cats and dog”，“cat sand dog”]。
 * Created by Tony on 2017/5/17.
 */
public class 根据单词构造句子2 {
    public static ArrayList<String> wordBreak(String s, Set<String> dict) {

        //dp[i]表示s[0,i)是可分割的。
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        //prev[i][j]表示s[j,i)是一个单词
        boolean[][] prev = new boolean[s.length() + 1][s.length()];

        for (int i = 0; i <= s.length(); i++) {
            for (int j = i-1; j >= 0; j--) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    //prev[i][j]表示s[j,i)是一个单词
                    prev[i][j] = true;
                }
            }
        }

        ArrayList<String> res = new ArrayList<>();
        ArrayList<String> path = new ArrayList<>();
        dfs(s, prev, s.length(), res, path);
        return res;
    }

    private static void dfs(String s, boolean[][] prev, int cur, ArrayList<String> res, ArrayList<String> path) {
        if (cur == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = path.size() - 1; i >= 0; i--) {
                sb.append(path.get(i) + " ");
            }
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
            //不能直接清空path,因为得保留已有的
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (prev[cur][i]) {
                //添加路径
                path.add(s.substring(i, cur));
                //递归添加
                dfs(s, prev, i, res, path);
                //删除掉之前添加的。
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String s ="catsanddog";
        Set<String> dict = new HashSet<>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");

        ArrayList<String> strings = wordBreak(s, dict);
        for (String s1 :
                strings) {
            System.out.println(s1);
        }
    }
}
