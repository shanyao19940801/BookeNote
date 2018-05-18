package jianzhi.capter02.c02;

/**
 * Created by user on 2018/2/28.
 * 线程安全的懒汉模式，但是效率低下
 */
public class Singleton2 {
    private static Singleton2 instance;

    public Singleton2() {
    }

    public static synchronized Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}
