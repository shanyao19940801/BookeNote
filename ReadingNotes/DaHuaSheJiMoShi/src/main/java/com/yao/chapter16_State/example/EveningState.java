package com.yao.chapter16_State.example;

/**
 * Created by shanyao on 2018/5/30.
 */
public class EveningState extends State {
    public void writeProgram(Work work) {
        if (work.isFinish()) {
            //如果工作完成，xiaban
            work.setCurrent(new RestState());
            work.writeProgram();
        } else {
            if (work.getHour() <21){
                System.out.println("当前时间：" + work.getHour() +  "点，加班哦，疲累至极");
            } else {
                work.setCurrent(new SleepingState());//超过九点睡觉
                work.writeProgram();
            }
        }
    }
}
