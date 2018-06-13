package com.yao.chapter26_Flyweight;

import java.util.Hashtable;

/**
 * Created by shanyao on 2018/6/13.
 * 享元工厂，用来创建并管理Flyweight对象。它主要是用来确保合理地共享Flyweight，当用户请求一个Flyweight时，
 * FlyweightFactory对象提供一个已经创建的实例或者创建一个（如果不存在的话）
 */
public class FlyweightFactory {
    private Hashtable flyweights = new Hashtable();

    public FlyweightFactory() {
        flyweights.put("X",new ConcreteFlyweight());
        flyweights.put("Y",new ConcreteFlyweight());
        flyweights.put("Z",new ConcreteFlyweight());
    }

    public Flyweight getFlyweight(String key) {
        return (Flyweight) flyweights.get(key);
    }
}
