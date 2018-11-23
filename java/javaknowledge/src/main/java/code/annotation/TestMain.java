package code.annotation;

@MyAnnotation(value = Name.hao)
public class TestMain {
    public static void main(String[] args) {
        System.out.println(Name.hao.getNum());
    }
}
