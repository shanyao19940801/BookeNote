package com.code.callback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        User user = new User("shanyao", new Integer(23));
        Map<String, User> map1 = new HashMap<>();
        Map<String, User> map2 = new HashMap<>();
        map1.put("1", user);
        map2.put("1", user);

        map1.get("1").setAge(new Integer(24));

        System.out.println(map1.get("1"));
        System.out.println(map2.get("1"));
    }
}
