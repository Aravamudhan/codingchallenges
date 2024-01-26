package com.arav.wordCount.service.utils;

import com.arav.wordCount.utils.OptionHandler;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static com.arav.wordCount.service.config.TestConstants.TEST_STRING1;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OptionHandlerTest {
    @Test
    public void defaultOptionsTest(){
        OptionHandler optionHandler  = new OptionHandler();
        optionHandler.setFileContents(TEST_STRING1.getBytes(StandardCharsets.UTF_8));
        List<Integer> defaultOptionCounts = optionHandler.getDefaultOptions();
        assertNotNull(defaultOptionCounts);
    }

    @Test
    public void byteCountTest(){
        OptionHandler optionHandler  = new OptionHandler();
        optionHandler.setFileContents(TEST_STRING1.getBytes(StandardCharsets.UTF_8));
        int byteCount = optionHandler.getByteCount();
        assertEquals(23,byteCount);
    }

    @Test
    public void wordCountTest(){
        OptionHandler optionHandler  = new OptionHandler();
        optionHandler.setFileContents(TEST_STRING1.getBytes(StandardCharsets.UTF_8));
        int wordCount = optionHandler.getWordCount();
        assertEquals(4,wordCount);
    }

    @Test
    public void lineCountTest(){
        OptionHandler optionHandler  = new OptionHandler();
        optionHandler.setFileContents(TEST_STRING1.getBytes(StandardCharsets.UTF_8));
        int lineCount = optionHandler.getLineCount();
        assertEquals(2,lineCount);
    }

    @Test
    public void charCountTest(){
        OptionHandler optionHandler  = new OptionHandler();
        optionHandler.setFileContents(TEST_STRING1.getBytes(StandardCharsets.UTF_8));
        int charCount = optionHandler.getCharCount();
        assertEquals(23,charCount);

    }

}
