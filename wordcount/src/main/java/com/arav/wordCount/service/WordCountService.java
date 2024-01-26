package com.arav.wordCount.service;

import java.util.List;

public interface WordCountService {
    public List<Integer> getWordCount(byte[] data, String...options);
}
