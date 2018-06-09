package com.yao.chapter23_Command.example;

/**
 * Created by shanyao on 2018/6/9.
 * 服务员
 */
public class Waiter {
    private CommandE command;
    //设置订单
    public void setOrder(CommandE command) {
        this.command = command;
    }
    //通知执行
    public void Notify() {
        command.executeCommand();
    }
}
