package com.yao.chapter23_Command;

/**
 * Created by shanyao on 2018/6/9.
 */
public class ConcreteCommand extends Command {
    public ConcreteCommand(Receiver receiver) {
        super(receiver);
    }

    public void execute() {
        receiver.action();
    }
}
