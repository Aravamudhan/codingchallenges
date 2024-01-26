package com.arav.wordCount.utils;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class OptionHandler {
    private byte[] fileContents = null;
    final int LINE_BREAK = 0XA;

    public void setFileContents(byte[] fileContents) {
        this.fileContents = fileContents;
    }

    public int getByteCount(){
        return fileContents.length;
    }
    public int getWordCount(){
        String words = null;
        try {
            words = new String(fileContents, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            System.out.println("Unsupported encoding");
            return 0;
        }
        String[] wordArray = words.split("\\s+");
        return wordArray.length;
    }
    public int getLineCount(){
        int lineCount = 1;
        for (byte b : fileContents) {
            if (b == LINE_BREAK) {
                lineCount++;
            }
        }
        return lineCount;
    }
    public int getCharCount(){
        int charCount = 0;
        try {
            charCount = new String(fileContents, "UTF-8").toCharArray().length;
        } catch (UnsupportedEncodingException e) {
            System.out.println("Unsupported encoding");
            return 0;
        }
        return charCount;
    }

    public List<Integer> getDefaultOptions(){
        return List.of(getByteCount(), getLineCount(), getWordCount());
    }
}
