package com.yao.chapter25_Mediator;

/**
 * Created by shanyao on 2018/6/11.
 */
public class ConcreteColleague1 extends Colleague {
    public ConcreteColleague1(Mediator mediator) {
        super(mediator);
    }

    public void send(String message) {
        mediator.send(message, this);
    }

    public void MyNotify(String message) {
        System.out.println("同事2得到消息" + message);
    }

}
