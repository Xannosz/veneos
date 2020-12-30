package hu.xannosz.veneos.core.handler;

import hu.xannosz.microtools.pack.Douplet;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FileContainer {
    private static final Map<String, Douplet<String, File>> files = new HashMap<>();

    // contentType = application/pdf => pdf handler
    public static void addFile(String key, String contentType, File file) {
        files.put(key, new Douplet<>(contentType, file));
    }

    public static void addFile(String key, File file) {
        files.put(key, new Douplet<>("", file));
    }

    public static Douplet<String, File> getFile(String key) {
        return files.get(key);
    }
}
