package com.yao.chapter16_State.example;

/**
 * Created by shanyao on 2018/5/30.
 */
public class NoonState extends State {
    public void writeProgram(Work work) {
        if (work.getHour() < 13) {
            System.out.println("当前时间：" + work.getHour() +" 点，饿了，午饭；犯困，午休");
        } else {
            work.setCurrent(new AfterNoonState());
            work.writeProgram();
        }
    }
}
