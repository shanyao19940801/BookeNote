package com.thinkf.chapter09.c03;

public class Test29 {
    public static void main(String[] args){

        PowerA a = new PowerAImpl();

        //connect(a);

        PowerB b = new PowerBImpl();

        PowerAdapter pa = new PowerAdapter(b);

        connect(pa);

    }

    //此方法只能接收PowerA接口，不兼容其它接口

    public static void connect(PowerA powerA){

        System.out.println("开始工作之前的准备");

        powerA.connect();



        //

    }

       /*

       public static void insert(PowerB powerB){

              powerB.insert();

       }

       */

}

//适配器：实现的接口表示要匹配的接口，内部维护的接口表示被匹配的接口

class PowerAdapter implements PowerA{

    private PowerB powerB;

    public PowerAdapter(PowerB powerB){

        this.powerB = powerB;

    }

    public void connect(){

        powerB.insert();

    }

}



//电源A

interface PowerA{

    public void connect();

}

class PowerAImpl implements PowerA{

    public void connect(){

        System.out.println("电源A已连接，开始工作");

    }

}

//电源B

interface PowerB{

    public void insert();

}

class PowerBImpl implements PowerB{

    public void insert(){

        System.out.println("电源B已插入，开始工作");

    }

}
