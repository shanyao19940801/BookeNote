package com.yao.chapter15_AbstractFactory.example;

/**
 * Created by shanyao on 2018/5/28.
 * 创建一个工厂创造器/生成器类，通过传递形状或颜色信息来获取工厂。
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        //TODO 这里违反了开闭原则 每次新增一个新的Factory都要修改代码
        if(choice.equalsIgnoreCase("SHAPE")){
            return new ShapeFactory();
        } else if(choice.equalsIgnoreCase("COLOR")){
            return new ColorFactory();
        }
        return null;
    }

    // 优化 利用反射原理
    public static AbstractFactory getFactory(Class clzz) {
        try {
            return (AbstractFactory)clzz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
