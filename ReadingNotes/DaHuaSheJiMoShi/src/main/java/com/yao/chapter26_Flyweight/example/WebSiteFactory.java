package com.yao.chapter26_Flyweight.example;

import java.util.Hashtable;

/**
 * Created by shanyao on 2018/6/13.
 */
public class WebSiteFactory {
    private Hashtable flyweight = new Hashtable();

    //获得网站分类
    public WebSite getWebSiteCategory(String key){
        if (!flyweight.contains(key))
            flyweight.put(key, new ConcreteWebSite(key));
        return (WebSite) flyweight.get(key);
    }

    public int getWebCount() {
        return flyweight.size();
    }
}
