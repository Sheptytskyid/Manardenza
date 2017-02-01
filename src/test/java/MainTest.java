import com.manardenza.Main;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

public class MainTest {

    org.slf4j.Logger log = LoggerFactory.getLogger(MainTest.class);

    @Test
    public void test() {
        assertEquals(1, new Main().test());
        log.info("222");
    }
}