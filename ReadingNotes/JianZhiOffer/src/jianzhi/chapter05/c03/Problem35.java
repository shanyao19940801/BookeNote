package jianzhi.chapter05.c03;

import java.util.*;

/**
 * Created by shanyao on 2018/7/3.
 */
public class Problem35 {
    public int FirstNotRepeatingChar(String str) {
        HashMap<Character,Node> map = new HashMap<>();
        ArrayList<Node> lists = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (!map.containsKey(temp)) {
                Node node = new Node(temp,i);
                lists.add(node);
                map.put(temp,node);
            } else {
                lists.remove(map.get(temp));
            }
        }
        Collections.sort(lists,new  MyComptratable());
        if (lists.size() > 0) {
            return lists.get(0).index;
        }
        return -1;
    }

    class MyComptratable implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.index > o2.index ? 1 : o1.index == o2.index ? 0 : -1;
        }
    }
    class Node {
        char c;
        int index;
        public Node(char c, int index) {
            this.c = c;
            this.index = index;
        }
    }
}
