package hu.xannosz.veneos.core;

import org.apache.commons.lang.exception.ExceptionUtils;

public interface LogHandler {
	public void log(LogLevel level, String reason, String message);

	public default void trace(String reason, String message) {
		log(LogLevel.TRACE, reason, message);
	}

	public default void debug(String reason, String message) {
		log(LogLevel.DEBUG, reason, message);
	}

	public default void info(String reason, String message) {
		log(LogLevel.INFO, reason, message);
	}

	public default void warn(String reason, String message) {
		log(LogLevel.WARNING, reason, message);
	}

	public default void error(String reason, String message) {
		log(LogLevel.ERROR, reason, message);
	}

	public default void trace(String message) {
		log(LogLevel.TRACE, "", message);
	}

	public default void debug(String message) {
		log(LogLevel.DEBUG, "", message);
	}

	public default void info(String message) {
		log(LogLevel.INFO, "", message);
	}

	public default void warn(String message) {
		log(LogLevel.WARNING, "", message);
	}

	public default void error(String message) {
		log(LogLevel.ERROR, "", message);
	}

	public default void trace(String message, Throwable e) {
		log(LogLevel.TRACE, ExceptionUtils.getStackTrace(e), message);
	}

	public default void debug(String message, Throwable e) {
		log(LogLevel.DEBUG, ExceptionUtils.getStackTrace(e), message);
	}

	public default void info(String message, Throwable e) {
		log(LogLevel.INFO, ExceptionUtils.getStackTrace(e), message);
	}

	public default void warn(String message, Throwable e) {
		log(LogLevel.WARNING, ExceptionUtils.getStackTrace(e), message);
	}

	public default void error(String message, Throwable e) {
		log(LogLevel.ERROR, ExceptionUtils.getStackTrace(e), message);
	}

	public default void trace(Throwable e) {
		log(LogLevel.TRACE, ExceptionUtils.getStackTrace(e), "");
	}

	public default void debug(Throwable e) {
		log(LogLevel.DEBUG, ExceptionUtils.getStackTrace(e), "");
	}

	public default void info(Throwable e) {
		log(LogLevel.INFO, ExceptionUtils.getStackTrace(e), "");
	}

	public default void warn(Throwable e) {
		log(LogLevel.WARNING, ExceptionUtils.getStackTrace(e), "");
	}

	public default void error(Throwable e) {
		log(LogLevel.ERROR, ExceptionUtils.getStackTrace(e), "");
	}

	public enum LogLevel {
		TRACE, DEBUG, INFO, WARNING, ERROR;
	}
}
