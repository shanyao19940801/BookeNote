package com.yao.chapter20_Iterator;

/**
 * Created by shanyao on 2018/6/4.
 */
public class ConcreteIterator extends Iterator {

    private ConcreteAggregate aggregate;
    private int current = 0;
    public ConcreteIterator(ConcreteAggregate aggregate) {
        this.aggregate = aggregate;
    }

    public Object first() {
        return aggregate.get(0);
    }

    public Object next() {
        Object ret = null;
        current++;
        if (current < aggregate.cout()) {
            ret = aggregate.get(current);
        }
        return ret;
    }

    public boolean isDone() {
        return current >= aggregate.cout() ? true : false;
    }

    public Object currentItem() {
        return aggregate.get(current);
    }
}
