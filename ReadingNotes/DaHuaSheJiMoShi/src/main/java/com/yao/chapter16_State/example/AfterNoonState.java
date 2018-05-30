package com.yao.chapter16_State.example;

/**
 * Created by shanyao on 2018/5/30.
 */
public class AfterNoonState extends State {
    public void writeProgram(Work work) {
        if (work.getHour() < 17) {
            System.out.println("当前时间："+ work.getHour() + "点，下午状态可以，继续工作");
        } else {
            work.setCurrent(new EveningState());
            work.writeProgram();
        }
    }
}
