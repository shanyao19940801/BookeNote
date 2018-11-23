package code.annotation;

public enum Name {
    yao(1, "shanyao"),
    hao(2, "shanhao");

    private Integer num;
    private String name;

    Name(Integer num, String name) {
        this.name = name;
        this.num = num;
    }
}
