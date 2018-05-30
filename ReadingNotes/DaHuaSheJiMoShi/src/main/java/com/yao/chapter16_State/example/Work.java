package com.yao.chapter16_State.example;

/**
 * Created by shanyao on 2018/5/30.
 */
public class Work {
    private State current;
    private double hour;//时间属性状态转换依据
    private boolean finish = false;

    public Work() {
        this.current = new ForenoonState();
    }

    public State getCurrent() {
        return current;
    }

    public void setCurrent(State current) {
        this.current = current;
    }

    public double getHour() {
        return hour;
    }

    public void setHour(double hour) {
        this.hour = hour;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public void writeProgram() {
        current.writeProgram(this);
    }
}
