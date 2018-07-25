package com.yao.chapter02strategy.image.example;

/**
 * Created by shanyao on 2018/7/25.
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void ContextInterface() {
        strategy.AlgorithmInterface();
    }

}
