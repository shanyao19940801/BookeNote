package jianzhi.capter02.c02;

/**
 * Created by user on 2018/2/28.
 * 饿汉模式
 * 在程序一开始就加载好类
 * 线程安全
 */
public class Singleton4 {
    private static Singleton4 instance;

    public Singleton4() {
    }

    public static Singleton4 getInstance() {
        return instance;
    }
}
