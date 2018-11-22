package scheduledexecutor;

public class MyScheduledExecutor implements Runnable {

    private String name;
    public MyScheduledExecutor(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name);
    }
}
