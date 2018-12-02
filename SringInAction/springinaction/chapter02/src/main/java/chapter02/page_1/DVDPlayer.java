package chapter02.page_1;

import chapter02.CompactDisc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DVDPlayer implements MediaPlayer{
    private CompactDisc disc;
    @Override
    public void play() {
        disc.play();
    }

    //通过这种方式装配bean要注意，满足条件的bean有且只能有一个，
    // 多个都会报错，没有也会报错（如果required=false就不会报错，此时的bean是未装配状态）
    @Autowired
    public DVDPlayer(CompactDisc disc) {
        this.disc = disc;
    }
}
