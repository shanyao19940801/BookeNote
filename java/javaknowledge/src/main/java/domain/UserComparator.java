package domain;

import com.google.common.collect.ComparisonChain;

import java.util.Comparator;

public class UserComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return ComparisonChain.start().compare(o1.getPrice(), o2.getPrice()).result();
    }
}
