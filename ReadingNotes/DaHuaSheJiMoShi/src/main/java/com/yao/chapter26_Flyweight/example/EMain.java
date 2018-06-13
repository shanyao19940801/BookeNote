package com.yao.chapter26_Flyweight.example;

/**
 * Created by shanyao on 2018/6/13.
 */
public class EMain {
    public static void main(String[] args) {

        WebSiteFactory factory = new WebSiteFactory();

        WebSite fx = factory.getWebSiteCategory("产品展示");
        fx.Use(new User("小菜"));

        WebSite fy = factory.getWebSiteCategory("产品展示");
        fx.Use(new User("大鸟"));

        WebSite fz = factory.getWebSiteCategory("产品展示");
        fx.Use(new User("娇娇"));

        WebSite fl = factory.getWebSiteCategory("产品展示");
        fx.Use(new User("萧山"));

        WebSite fm = factory.getWebSiteCategory("产品展示");
        fx.Use(new User("王二麻子"));

        WebSite fn = factory.getWebSiteCategory("产品展示");
        fx.Use(new User("得到"));

    }

}
