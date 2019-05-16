package maptst;

import java.util.concurrent.CountDownLatch;

/**
 * Created by shanyao on 2019/5/14
 */
public class MapTestRunnable implements Runnable {
    private final CountDownLatch begin;
    private final CountDownLatch end;


    public MapTestRunnable(CountDownLatch begin, CountDownLatch end){
        this.begin  = begin;
        this.end  = end;
    }

    @Override
    public void run(){
        try {
            begin.await();//每个参赛选手都站在自己的跑道上，做好了比赛的准备，正在等裁判鸣枪开始比赛
            service.testMethod();//听到鸣枪后比赛开始了
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            end.countDown();//其中的一个参赛选手已经跑完了
        }

    }
}
