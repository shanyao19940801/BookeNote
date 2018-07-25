package com.yao.chapter02strategy.image.example;

/**
 * Created by shanyao on 2018/7/25.
 */
public class Main {
    public static void main(String[] args) {
        Context context;
        Strategy strategyA = new ConcreteStrategyA();
        context = new Context(strategyA);
        context.ContextInterface();

        context = new Context(new ConcreteStrategyB());
        context.ContextInterface();
    }
}
