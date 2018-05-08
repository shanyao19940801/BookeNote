package MyStudy;

import java.util.ArrayList;
import java.util.List;

public class SubListTest {
    public static void main(String[] args) {
        int num = 51;
        List<Integer> list = new ArrayList();
        for (int i = 1; i<=num;i++) {
            list.add(i);
        }

        int n = num/10;
        List a = list.subList(0,10);
        List b = list.subList(10,14);
        for (int i = 0; i <= n; i++) {
            List t = null;
            try {
                t = list.subList(i*10,(i+1)*10);
            } catch (Exception e) {
                t = list.subList(i*10,list.size());
            }
            System.out.println(t);
        }

    }
}
