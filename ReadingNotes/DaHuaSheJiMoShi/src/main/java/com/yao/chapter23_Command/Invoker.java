package com.yao.chapter23_Command;

/**
 * Created by shanyao on 2018/6/9.
 */
public class Invoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommond() {
        command.execute();
    }

}
