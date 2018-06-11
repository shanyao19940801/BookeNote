package com.yao.chapter25_Mediator;

/**
 * Created by shanyao on 2018/6/11.
 * 具体中介者类
 */
public class ConcreteMediator extends Mediator {

    private ConcreteColleague1 colleague1;
    private ConcreteColleague2 colleague2;

    public void send(String message, Colleague colleague) {
        if (colleague == colleague1) {
            colleague2.MyNotify(message);
        } else {
            colleague1.MyNotify(message);
        }
    }

    public void setColleague1(ConcreteColleague1 colleague1) {
        this.colleague1 = colleague1;
    }

    public void setColleague2(ConcreteColleague2 colleague2) {
        this.colleague2 = colleague2;
    }
}
