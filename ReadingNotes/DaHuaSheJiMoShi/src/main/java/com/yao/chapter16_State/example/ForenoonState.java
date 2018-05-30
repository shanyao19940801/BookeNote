package com.yao.chapter16_State.example;

/**
 * Created by shanyao on 2018/5/30.
 */
public class ForenoonState extends State {
    public void writeProgram(Work work) {
        if (work.getHour() < 12) {
            System.out.println("当前时间：" + work.getHour() + " 上午工作，精神百倍");
        } else {
            work.setCurrent(new NoonState());
            work.writeProgram();
        }
    }
}
