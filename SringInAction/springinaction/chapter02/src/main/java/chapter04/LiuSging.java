package chapter04;

import org.springframework.stereotype.Component;

@Component
public class LiuSging implements Performance {
    @Override
    public void perform() {
        System.out.println("刘德华唱歌");
    }
}
