package com.arav.wordCount.utils;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ResourceReader {
    public byte[] readResource(String resource) throws IOException;
}
