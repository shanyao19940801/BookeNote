package skill;

import com.google.common.collect.ComparisonChain;

import java.util.Comparator;

public class SortSkill implements Comparator {
    /*@Override
    public int compare(AnswerPackage o1, AnswerPackage o2) {
        return ComparisonChain.start()
                .compare(o1.getContainTimeLength(), o2.getContainTimeLength())
                .compare(o2.getDiscountPrice(), o1.getDiscountPrice())
                .result();
    }*/

    public int compare(Object o1, Object o2) {
        return 0;
    }
}
