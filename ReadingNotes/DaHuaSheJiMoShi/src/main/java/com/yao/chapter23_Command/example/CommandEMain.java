package com.yao.chapter23_Command.example;

import com.yao.chapter23_Command.Command;

/**
 * Created by shanyao on 2018/6/9.
 */
public class CommandEMain {
    public static void main(String[] args) {
        //开店准备
        Barbecuer boy = new Barbecuer();
        CommandE bakeMutonCommand1= new BakeMuttonCommand(boy);
        CommandE bakeMutonCommand2= new BakeMuttonCommand(boy);
        CommandE bakeChilckenWingCommand1 = new BakeChickenWingCommand(boy);
        Waiter girl = new Waiter();

        //开门营业
        girl.setOrder(bakeMutonCommand1);
        girl.Notify();
        girl.setOrder(bakeMutonCommand2);
        girl.Notify();
        girl.setOrder(bakeChilckenWingCommand1);
        girl.Notify();

        //TODO 上面这种方式每次点一种都要通知后厨




    }
}
