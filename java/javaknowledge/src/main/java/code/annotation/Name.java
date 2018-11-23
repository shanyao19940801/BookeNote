package code.annotation;

public enum Name {
    yao(1, "shan", "yao"),
    hao(2, "shan", "hao");

    private Integer num;
    private String lastName;
    private String name;
    Name(Integer num, String name, String lastName) {
        this.name = name;
        this.num = num;
        this.lastName = lastName;
    }

    public Integer getNum() {
        return num;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getName() {
        return this.name;
    }

    

}
