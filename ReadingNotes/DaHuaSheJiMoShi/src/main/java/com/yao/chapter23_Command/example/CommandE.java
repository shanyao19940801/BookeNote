package com.yao.chapter23_Command.example;

import com.yao.chapter23_Command.Command;

/**
 * Created by shanyao on 2018/6/9.
 */
public abstract class CommandE {

    protected Barbecuer recever;

    public CommandE(Barbecuer recever) {
        this.recever = recever;
    }
    //执行命令
    abstract public void executeCommand();

}
