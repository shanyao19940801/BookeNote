package code.string;

/**
 * @create by  单耀
 * @create date  2019/6/11
 */
public class StringTest {
    public static void main(String[] args) {
        String msg = String.format("您的%d月排课表已确认，如有疑问请及时联系教学助理\t", 3);
        System.out.println(msg);
    }
}
