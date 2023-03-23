package no.hiof.webframework.Application.Logging;

import org.eclipse.jetty.util.log.StdErrLog;

/**
 * Logger is a utility class for turning off Jetty logging.
 */
public class Logger {
    /**
     * Turns off Jetty logging by setting the logging level to OFF.
     */
    public static void turnLoggerOFF() {
        System.setProperty("org.eclipse.jetty.util.log.class", "org.eclipse.jetty.util.log.StdErrLog");
        System.setProperty("org.eclipse.jetty.LEVEL", "OFF");
        org.eclipse.jetty.util.log.StdErrLog logger = new org.eclipse.jetty.util.log.StdErrLog();
        logger.setLevel(StdErrLog.LEVEL_OFF);
        org.eclipse.jetty.util.log.Log.setLog(logger);
    }
}
