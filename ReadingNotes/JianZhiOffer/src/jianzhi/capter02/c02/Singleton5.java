package jianzhi.capter02.c02;

/**
 * Created by user on 2018/2/28.
 * 修改饿汉模式，使用静态内部类，实现lazy loading
 * 线程安全
 */
public class Singleton5 {

    private static class SingletonHandle{
        private  static Singleton5 instance = new Singleton5();
    }

    public Singleton5() {
        System.out.println("Singleton 已经加载");
    }

    public static Singleton5 getInstatnce() {
        return SingletonHandle.instance;
    }
}
