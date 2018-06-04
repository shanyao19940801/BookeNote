package com.yao.chapter20_Iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shanyao on 2018/6/4.
 */
public class ConcreteAggregate extends Aggregate{
    private List<Object> items = new ArrayList<Object>();
    public Iterator createIterator() {
        return new ConcreteIterator(this);
    }
    public int cout(){
        return items.size();
    }

    public Object get(int index) {
        return items.get(index);
    }

    public void put(Object o) {
        items.add(o);
    }


}
