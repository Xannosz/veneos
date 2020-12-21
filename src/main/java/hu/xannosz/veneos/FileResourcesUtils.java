package hu.xannosz.veneos;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class FileResourcesUtils {

    public static void main(String[] args) throws IOException {

        String fileName = "json/file1.json";

        System.out.println("getResourceAsStream : " + fileName);
        InputStream is = getFileFromResourceAsStream(fileName);
        File file = streamToTempFile(is);
        System.out.println("##" + file);
    }

    private static File streamToTempFile(InputStream in) throws IOException {
        File tempFile = File.createTempFile("resourceFile", UUID.randomUUID().toString()
                .replace("-", ""));
        tempFile.deleteOnExit();
        FileUtils.copyInputStreamToFile(in, tempFile);
        return tempFile;
    }

    private static InputStream getFileFromResourceAsStream(String fileName) {
        ClassLoader classLoader = FileResourcesUtils.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }
    }
}
