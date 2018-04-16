package MyStudy;

/**
 * Created by shanyao on 2018/4/11.
 */
public class HashCodeTest {
        public static void main(String[] argv) throws Exception {
//    File file1 = new File("a");
//    File file2 = new File("a");
//    File file3 = new File("b");

            String file1 = "abc";
            String file2 = "abc";
            String file3 = "abcdef";


            int hc1 = file1.hashCode();
            System.out.println(hc1);
            int hc2 = file2.hashCode();
            System.out.println(hc2);
            int hc3 = file3.hashCode();
            System.out.println(hc3);
            int ihc1 = System.identityHashCode(file1);
            System.out.println(ihc1);
            int ihc2 = System.identityHashCode(file2);
            System.out.println(ihc2);
            int ihc3 = System.identityHashCode(file3);
            System.out.println(ihc3);
        }
}
