package com.thinkf.chapter07.c07;

class Instrument {
    public void play(){}
    //这里的参数是Instrument却可以接受Wind类型的对象
    static void tune(Instrument i) {
        i.play();
    }
}
public class Wind extends Instrument{
    public static void main(String[] args) {
        Wind f = new Wind();
        Instrument.tune(f);//向上转型
    }
}
