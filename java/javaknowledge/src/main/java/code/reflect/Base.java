package code.reflect;

public class Base {
    static int num = 1;

    static {
        System.out.println("Base" + num);
    }
}
