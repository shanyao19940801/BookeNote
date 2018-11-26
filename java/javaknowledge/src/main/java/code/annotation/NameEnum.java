package code.annotation;

public enum NameEnum {
    yao(1, "shan", "yao"),
    hao(2, "shan", "hao");

    private Integer num;
    private String lastName;
    private String name;
    NameEnum(Integer num, String lastName, String name) {
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

    public static NameEnum valueOf(Integer num) throws Exception {
        NameEnum[] var1 = values();
        int var2 = var1.length;

        for (int var3 = 0; var3 < var2; ++var3) {
            NameEnum nameEnum = var1[var3];
            if (nameEnum.getNum().equals(num)) {
                return nameEnum;
            }
        }
        throw new Exception("miss");
    }

}
