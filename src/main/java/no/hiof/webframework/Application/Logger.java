package no.hiof.webframework.Application;

import org.eclipse.jetty.util.log.StdErrLog;

class Logger {

    protected static void turnLoggerOFF() {
        System.setProperty("org.eclipse.jetty.util.log.class", "org.eclipse.jetty.util.log.StdErrLog");
        System.setProperty("org.eclipse.jetty.LEVEL", "OFF");
        org.eclipse.jetty.util.log.StdErrLog logger = new org.eclipse.jetty.util.log.StdErrLog();
        logger.setLevel(StdErrLog.LEVEL_OFF);
        org.eclipse.jetty.util.log.Log.setLog(logger);
    }
}
