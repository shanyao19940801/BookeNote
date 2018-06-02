package com.yao.chapter18_Memento;

/**
 * Created by shanyao on 2018/6/2.
 */
public class Originator {
    private String state;

    //创建备忘录，将当前需要保存的信息导入并实例化一个Memento对象
    public Memento createMemento() {
        return new Memento(state);
    }

    //恢复备忘录，将Memento导入并将相关数据恢复
    public void setMemento(Memento memento) {
        state = memento.getState();
    }
    //显示数据
    public void show() {
        System.out.println("State="+state);
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
