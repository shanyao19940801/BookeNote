package com.yao.six_principle.DependenceInversionPrinciple.example01;

/**
 * Created by shanyao on 2018/5/8.
 */
public class XiaoMing implements IReader{

    public void reader(IRead read) {
        read.read();
    }
}
