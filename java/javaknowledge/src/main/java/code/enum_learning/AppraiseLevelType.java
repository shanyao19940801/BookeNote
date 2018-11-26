package code.enum_learning;

public enum AppraiseLevelType {
    unknown(-1, -1, -1),
    best(1, 4, 5),
    middle(2, 2, 3),
    worst(3, 1, 1);

    private Integer value;
    private Integer startStar;
    private Integer endStar;

    private AppraiseLevelType(Integer value, Integer startStar, Integer endStar) {
        this.value = value;
        this.startStar = startStar;
        this.endStar = endStar;
    }

    public Integer getValue() {
        return this.value;
    }

    public AppraiseLevelType getDefault() {
        return unknown;
    }

    public Integer getStartStar() {
        return this.startStar;
    }

    public Integer getEndStar() {
        return this.endStar;
    }

    public static AppraiseLevelType valueOf(Integer value) throws Exception {
        AppraiseLevelType[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            AppraiseLevelType type = var1[var3];
            if (type.getValue().equals(value)) {
                return type;
            }
        }
        throw new Exception("no ");
//        throw new ConvertException("get AppraiseLevelType of value:" + value + " fail.");
    }

    public static AppraiseLevelType starTransform(Integer star) throws Exception {
        AppraiseLevelType[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            AppraiseLevelType type = var1[var3];
            if (star >= type.getStartStar() && star <= type.getEndStar()) {
                return type;
            }
        }
        throw new Exception("no ");
//        throw new ConvertException("star Transform AppraiseLevelType:" + star + " fail.");
    }
}

