package hu.xannosz.veneos.core;

public class DefaultLogHandler implements LogHandler {

    @Override
    public void log(LogLevel level, String reason, String message) {
        System.out.println("[" + level + "]\n\treason: " + reason + "\n\tmessage: " + message);
    }

}
