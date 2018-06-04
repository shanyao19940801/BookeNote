package com.yao.chapter20_Iterator;

import com.yao.chapter14_Observer.Observer;

/**
 * Created by shanyao on 2018/6/4.
 */
public class MainIterator {
    public static void main(String[] args) {
        ConcreteAggregate aggregate = new ConcreteAggregate();
        aggregate.put("大鸟");
        aggregate.put("小菜");
        aggregate.put("行李");
        aggregate.put("老外");
        aggregate.put("员工");
        aggregate.put("小偷");

        Iterator iterator = new ConcreteIterator(aggregate);

        Object item = iterator.first();

        while (!iterator.isDone()) {
            System.out.println(iterator.currentItem());
            System.out.println(iterator.next());
        }

    }
}
