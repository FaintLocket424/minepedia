package space.faintlocket.minepedia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Inspired by the IrisLogging class in the Iris Project

public class MinepediaLogging {
    private final Logger logger;

    public MinepediaLogging(String loggerName) {
        this.logger = LoggerFactory.getLogger(loggerName);
    }

    public void info(String info) {
        this.logger.info(info);
    }

    public void info(String info, Object... o) {
        this.logger.info(info, o);
    }

    public void debug(String debug) {
        this.logger.debug(debug);
    }
}
