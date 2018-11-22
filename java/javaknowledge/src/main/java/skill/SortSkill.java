package skill;

import com.google.common.collect.ComparisonChain;
import domain.User;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortSkill {
    public static void main(String[] args) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            User user = new User("shan", 22, format.parse("1994-08-01"));
            User user1 = new User("yao", 23, format.parse("1994-08-02"));
            User user2 = new User("hao", 21, format.parse("1994-08-01"));
            List<User> list = Arrays.asList(user, user1, user2);
            System.out.println(list.toString());
            Collections.sort(list, User.ageDescComparator);
            System.out.println(list.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
