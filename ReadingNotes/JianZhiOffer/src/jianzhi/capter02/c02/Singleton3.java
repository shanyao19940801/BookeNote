package jianzhi.capter02.c02;

/**
 * Created by user on 2018/2/28.
 * 创建单例
 * 将锁加在方法内部并通过双重判断来提高效率
 * 理论上是安全的，
 */
public class Singleton3 {
    private static Singleton3 instance;

    public static Singleton3 getInstance() {
        if (instance == null) {
            synchronized (Singleton3.class) {
                if (instance == null) {
                    instance = new  Singleton3();
                }
            }
        }
        return instance;
    }
}
