package chapter02;

import chapter02.config.CDPlayerConfig;
import chapter02.page_1.DVDPlayer;
import chapter02.page_2.VCDPlayer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {

    @Autowired
    private CompactDisc cd;
    @Autowired
    private DVDPlayer dvd;
    @Autowired
    private VCDPlayer vcd;

    @Test
    public void cdShouldNotBeNull() {
        assertNotNull(cd);
        assertNotNull(dvd);
        assertNotNull(vcd);
    }
}
