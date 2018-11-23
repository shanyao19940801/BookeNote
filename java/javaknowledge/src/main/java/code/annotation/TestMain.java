package code.annotation;

@MyAnnotation(value = Name.hao)
public class TestMain {
    public static void main(String[] args) {
        System.out.println(Name.hao.getNum());
        try {
            System.out.println(Name.valueOf(1));
            System.out.println(Name.valueOf("shan"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
