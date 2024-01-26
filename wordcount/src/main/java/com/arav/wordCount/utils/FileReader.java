package com.arav.wordCount.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader implements ResourceReader {
    @Override
    public byte[] readResource(String resource) throws IOException {
        File file = new File(resource);
        byte[] fileBytes = new byte[(int) file.length()];
        try (FileInputStream fileInputStream = new FileInputStream(file);) {
            fileInputStream.read(fileBytes);
            return fileBytes;
        }
    }
}
