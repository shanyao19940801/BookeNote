package com.yao.chapter16_State.example;

/**
 * Created by shanyao on 2018/5/30.
 */
public class SleepingState extends State {
    public void writeProgram(Work work) {
        System.out.println("当前时间：" + work.getHour() +  "点，睡觉");
    }
}
