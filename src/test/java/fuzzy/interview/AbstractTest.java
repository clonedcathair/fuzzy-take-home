package fuzzy.interview;

import java.util.logging.Logger;

public class AbstractTest {
    protected final Logger LOGGER = Logger.getLogger(String.valueOf(this));

    protected void LOG(Object obj) {
        String message = obj.toString();
        LOGGER.info(message);
    }
}
