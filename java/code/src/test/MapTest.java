package test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map map = new HashMap();

        map.put(2,"b");
        map.put(3,"c");
        map.put(4,"d");
        map.put(1,"a");
        getMap(map);
    }
    public static void getMap(Map<Integer,String> map) {
        for (Map.Entry<Integer,String> entry : map.entrySet()) {
            System.out.print(entry.getKey() + " ");
            System.out.println(entry.getValue());
        }
    }
}
