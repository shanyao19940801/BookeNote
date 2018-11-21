package com.skills.test.composer;

import com.skills.bean.User;
import com.skills.utils.CollectionsUtil;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class UserComposerTest {
    public static void main(String[] args) {
        List<User> list = getList();
        Map<Long, List<User>> listMap = CollectionsUtil.groupMapComposerId(list, User.USER_ID_COMPOSER);
        printMap(listMap);
        System.out.println();
        Map<Long, User> userMap = CollectionsUtil.mapComposerId(getList(),User.USER_ID_COMPOSER);
        for (Map.Entry<Long, User> entry : userMap.entrySet()) {
            System.out.println(entry.getKey()+"=="+entry.getValue());
        }
    }

    public static List<User> getList(){
        User u1 = new User(1L,"zhangsan", 22, new Date("1995/02/01"));
        User u2 = new User(2L,"zhangsan1", 22, new Date("1995/02/02"));
        User u5 = new User(2L,"zhangsan1", 25, new Date("1995/02/05"));
        User u3 = new User(3L,"zhangsan2", 22, new Date("1995/02/03"));
        User u4 = new User(4L,"zhangsan3", 22, new Date("1995/02/04"));
        List<User> list = Arrays.asList(u3,u4,u1,u5,u2);
        return list;
    }

    public static void printMap(Map<Long, List<User>> map) {
        for (Map.Entry<Long,List<User>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "==" + entry.getValue());
        }
    }
}
