package com.yao.chapter20_Iterator;

/**
 * Created by shanyao on 2018/6/4.
 */
public abstract class Iterator {
    public abstract Object first();
    public abstract Object next();
    public abstract boolean isDone();
    public abstract Object currentItem();
}
