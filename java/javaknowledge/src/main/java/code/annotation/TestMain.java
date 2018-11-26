package code.annotation;

@MyAnnotation(value = NameEnum.hao)
public class TestMain {
    public static void main(String[] args) {
        System.out.println(NameEnum.hao.getNum());
        try {
            System.out.println(NameEnum.valueOf(1));
            System.out.println(NameEnum.valueOf("yao"));
            System.out.println(NameEnum.valueOf(NameEnum.hao.getNum()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
