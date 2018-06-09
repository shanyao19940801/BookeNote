package com.yao.chapter23_Command;

/**
 * Created by shanyao on 2018/6/9.
 */
public abstract class Command {
    protected Receiver receiver;

    public Command(Receiver receiver) {
        this.receiver = receiver;
    }

    abstract public void execute();
}
