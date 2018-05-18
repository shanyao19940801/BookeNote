package jianzhi.capter02.c02;

/**
 * Created by user on 2018/2/28.
 * 懒汉模式，所谓懒汉就是只有在使用到才去加载
 * 线程不安全
 */
public class Singleton1 {
    private static Singleton1 instance;

    public Singleton1() {
    }

    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}
