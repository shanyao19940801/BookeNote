import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(100,100,0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(100));


    }
}
