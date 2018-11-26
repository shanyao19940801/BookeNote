package code.enum_learning;

public class AppraiseLevelTypeMain {
    public static void main(String[] args) {
        try {
            System.out.println(AppraiseLevelType.valueOf(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
