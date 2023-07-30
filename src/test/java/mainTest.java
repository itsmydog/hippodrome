import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

public class mainTest {

    @Disabled("Выкл")
    @Test
    @Timeout(value = 22, unit = TimeUnit.SECONDS)
    void mainTest() throws Exception {
        Main.main(null);

    }
}
