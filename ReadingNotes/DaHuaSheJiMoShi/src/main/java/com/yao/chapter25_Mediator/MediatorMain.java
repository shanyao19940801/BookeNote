package com.yao.chapter25_Mediator;

/**
 * Created by shanyao on 2018/6/11.
 */
public class MediatorMain {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();

        //需要让两个具体同事认识中介者对象
        ConcreteColleague1 colleague1 = new ConcreteColleague1(mediator);
        ConcreteColleague2 colleague2 = new ConcreteColleague2(mediator);

        //让中介者认识各个具体同事
        mediator.setColleague1(colleague1);
        mediator.setColleague2(colleague2);

        colleague1.send("吃放了吗");
        colleague2.send("没呢，你请客？");
    }
}
