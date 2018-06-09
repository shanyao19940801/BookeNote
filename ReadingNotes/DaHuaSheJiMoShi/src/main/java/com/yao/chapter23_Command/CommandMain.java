package com.yao.chapter23_Command;

/**
 * Created by shanyao on 2018/6/9.
 */
public class CommandMain {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command = new ConcreteCommand(receiver);
        Invoker i = new Invoker();
        i.setCommand(command);
        i.executeCommond();
    }
}
