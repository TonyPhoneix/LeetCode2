package 剑指offer;

import java.util.ArrayList;
import java.util.List;

public class 查找词汇 {
    public static void textQueries(List<String> sentences, List<String> queries) {
        // Write your code here
        for (String query : queries) {
            ArrayList<String> queryList = getStringList(query);
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < sentences.size(); i++) {
                ArrayList<String> stringList = getStringList(sentences.get(i));
                if (stringList.containsAll(queryList)) {
                    list.add(i);
                    System.out.print(i+" ");
                }
            }
            if (list.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }

    }

    public static ArrayList<String> getStringList(String str) {
        if (str != null && str.length() != 0) {
            String[] sentenceArr = str.split(" ");
            ArrayList<String> stringList = new ArrayList<>();
            for (String s : sentenceArr) {
                stringList.add(s);
            }
            return stringList;
        }
        return null;
    }

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("jim likes mary");
        list1.add("kate likes tom");
        list1.add("tom does not like jim");

        List<String> list2 = new ArrayList<>();
        list2.add("jim tom");
        list2.add("likes");
        textQueries(list1, list2);
    }
}
