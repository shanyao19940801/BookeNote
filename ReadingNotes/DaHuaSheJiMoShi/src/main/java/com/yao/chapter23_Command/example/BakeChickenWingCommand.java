package com.yao.chapter23_Command.example;

/**
 * Created by shanyao on 2018/6/9.
 */
public class BakeChickenWingCommand extends CommandE {
    public BakeChickenWingCommand(Barbecuer recever) {
        super(recever);
    }

    public void executeCommand() {
        recever.BakeChickenWing();
    }
}
