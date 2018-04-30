package chapter08.saturationpolicy;

/**
 * Created by shanyao on 2018/4/8.
 */
public class PrintTask implements Runnable {
    private int num;
    public PrintTask(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(num);
    }
}
