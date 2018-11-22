package code.reflect;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class clzz1 = Base.class;
        System.out.println("------");
        Class clzz2 = Class.forName("com.code.reflect.Base");
    }
}
