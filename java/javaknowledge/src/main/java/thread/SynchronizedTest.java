package thread;

public class SynchronizedTest {
    private String name;

    public SynchronizedTest(String name) {
        this.name = name;
    }

    public synchronized void test() {
        System.out.println(name);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
