package 深度优先搜索;

import java.util.ArrayList;

/**
 * 给定一个字符串s，分区使分区的每个子字符串都是回文。
 * 返回所有可能的回文分区。
 * 例如，给定s =“aab”，
 * 返回
 *   [
 *     [“AA”， “B”]，
 *     [ “A”， “A”， “B”]
 *   ]
 * Created by Tony on 2017/5/23.
 */
public class 生成回文串 {
    /**
     * 深度搜索 回溯法
     * @param s
     * @return
     */
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<String> path = new ArrayList<>();
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        dfs(s, path, result, 0);
        return result;
    }

    /**
     *
     * @param s
     * @param path
     * @param result
     * @param start
     */
    private void dfs(String s, ArrayList<String> path, ArrayList<ArrayList<String>> result, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {// 从i位置砍一刀
                path.add(s.substring(start, i + 1));
                dfs(s, path, result, i + 1);// 继续往下砍
                path.remove(path.size() - 1);// 撤销上上行
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end && s.charAt(start) == s.charAt(end)) {
            start++;
            end--;
        }
        return start >= end;
    }
}
