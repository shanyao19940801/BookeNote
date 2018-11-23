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

    public static Name valueOf(Integer num) throws Exception {
        Name[] var1 = values();
        int var2 = var1.length;

        for (int var3 = 0; var3 < var2; ++var3) {
            Name name = var1[var3];
            if (name.getNum().equals(num)) {
                return name;
            }
        }
        throw new Exception("miss");
    }

}
