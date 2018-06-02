package com.yao.chapter18_Memento;

/**
 * Created by shanyao on 2018/6/2.
 */
public class Main {
    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.setState("ON");
        originator.show();

        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(originator.createMemento());//保存状态，细节被封装的很好

        originator.setState("OFF");
        originator.show();

        //恢复状态
        originator.setMemento(caretaker.getMemento());
        originator.show();
    }
}
