package maptst;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by shanyao on 2019/5/14
 */
public class SameMethod{

    private static Map<Integer, Integer> maptst;

    public static void testMap() throws InterruptedException {
        maptst = new HashMap<>();
        for (int i = 0; i < 100; i ++) {
            maptst.put(i, i);
        }
    }
    private static int clientNum = 1000;
    private static int threadsNum = 10;
    /**
     * 计数器
     */
    final static CountDownLatch doneSignal = new CountDownLatch(clientNum);
    public static void main(String[] args) {
        /**
         * 建立线程池
         */
        ExecutorService exec = Executors.newFixedThreadPool(threadsNum);
        for(int i=0 ; i< clientNum; i++){
            MyRunnable myRunnable = new MyRunnable();
            exec.execute(myRunnable);
            doneSignal.countDown();
        }
    }

    static class  MyRunnable implements  Runnable{
        @Override
        public void run() {
            try{
                doneSignal.await();
                testMap();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


}
