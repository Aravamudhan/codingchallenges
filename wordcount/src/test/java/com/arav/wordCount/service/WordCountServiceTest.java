package com.arav.wordCount.service;

import com.arav.wordCount.utils.OptionHandler;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static com.arav.wordCount.service.config.TestConstants.TEST_STRING1;
import static org.junit.jupiter.api.Assertions.*;

public class WordCountServiceTest {
    @Test
    public void defaultTest(){
        WordCountService wordCountService = new WordCountServiceImpl(new OptionHandler());
        List<Integer> wordCountResult = wordCountService.getWordCount(TEST_STRING1.getBytes(StandardCharsets.UTF_8));
        assertNotNull(wordCountService);
        assertEquals(3,wordCountResult.size());
        assertTrue(wordCountResult.contains(2));
        assertTrue(wordCountResult.contains(4));
        assertTrue(wordCountResult.contains(23));
    }

    @Test
    public void byteCountTest(){
        WordCountService wordCountService = new WordCountServiceImpl(new OptionHandler());
        List<Integer> wordCountResult = wordCountService.getWordCount(TEST_STRING1.getBytes(StandardCharsets.UTF_8),"-c");
        assertTrue(wordCountResult.contains(23));
    }

    @Test
    public void wordCountTest(){
        WordCountService wordCountService = new WordCountServiceImpl(new OptionHandler());
        List<Integer> wordCountResult = wordCountService.getWordCount(TEST_STRING1.getBytes(StandardCharsets.UTF_8),"-w");
        assertTrue(wordCountResult.contains(4));
    }

    @Test
    public void lineCountTest(){
        WordCountService wordCountService = new WordCountServiceImpl(new OptionHandler());
        List<Integer> wordCountResult = wordCountService.getWordCount(TEST_STRING1.getBytes(StandardCharsets.UTF_8),"-l");
        assertTrue(wordCountResult.contains(2));
    }

    @Test
    public void charCountTest(){
        WordCountService wordCountService = new WordCountServiceImpl(new OptionHandler());
        List<Integer> wordCountResult = wordCountService.getWordCount(TEST_STRING1.getBytes(StandardCharsets.UTF_8),"-m");
        assertTrue(wordCountResult.contains(23));

    }
}
