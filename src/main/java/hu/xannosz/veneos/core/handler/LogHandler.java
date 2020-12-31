package hu.xannosz.veneos.core.handler;

import org.apache.commons.lang.exception.ExceptionUtils;

public interface LogHandler {
    void log(LogLevel level, String reason, String message);

    default void trace(String reason, String message) {
        log(LogLevel.TRACE, reason, message);
    }

    default void debug(String reason, String message) {
        log(LogLevel.DEBUG, reason, message);
    }

    default void info(String reason, String message) {
        log(LogLevel.INFO, reason, message);
    }

    default void warn(String reason, String message) {
        log(LogLevel.WARNING, reason, message);
    }

    default void error(String reason, String message) {
        log(LogLevel.ERROR, reason, message);
    }

    default void trace(String message) {
        log(LogLevel.TRACE, "", message);
    }

    default void debug(String message) {
        log(LogLevel.DEBUG, "", message);
    }

    default void info(String message) {
        log(LogLevel.INFO, "", message);
    }

    default void warn(String message) {
        log(LogLevel.WARNING, "", message);
    }

    default void error(String message) {
        log(LogLevel.ERROR, "", message);
    }

    default void trace(String message, Throwable e) {
        log(LogLevel.TRACE, ExceptionUtils.getStackTrace(e), message);
    }

    default void debug(String message, Throwable e) {
        log(LogLevel.DEBUG, ExceptionUtils.getStackTrace(e), message);
    }

    default void info(String message, Throwable e) {
        log(LogLevel.INFO, ExceptionUtils.getStackTrace(e), message);
    }

    default void warn(String message, Throwable e) {
        log(LogLevel.WARNING, ExceptionUtils.getStackTrace(e), message);
    }

    default void error(String message, Throwable e) {
        log(LogLevel.ERROR, ExceptionUtils.getStackTrace(e), message);
    }

    default void trace(Throwable e) {
        log(LogLevel.TRACE, ExceptionUtils.getStackTrace(e), "");
    }

    default void debug(Throwable e) {
        log(LogLevel.DEBUG, ExceptionUtils.getStackTrace(e), "");
    }

    default void info(Throwable e) {
        log(LogLevel.INFO, ExceptionUtils.getStackTrace(e), "");
    }

    default void warn(Throwable e) {
        log(LogLevel.WARNING, ExceptionUtils.getStackTrace(e), "");
    }

    default void error(Throwable e) {
        log(LogLevel.ERROR, ExceptionUtils.getStackTrace(e), "");
    }

    enum LogLevel {
        TRACE, DEBUG, INFO, WARNING, ERROR
    }
}
