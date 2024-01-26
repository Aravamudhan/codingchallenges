package com.arav.wordCount.service;

import com.arav.wordCount.utils.OptionHandler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.arav.wordCount.config.Constants.VALID_OPTIONS;

public class WordCountServiceImpl implements WordCountService {

    private final OptionHandler optionHandler;

    public WordCountServiceImpl(OptionHandler optionHandler) {
        this.optionHandler = optionHandler;
    }

    @Override
    public List<Integer> getWordCount(byte[] data, String... options) {
        // data is empty return empty string
        List<Integer> wordCountResult = new ArrayList<>();
        if (data == null || data.length == 0)
            return wordCountResult;
        // Sanitize the options
        Set<String> sanitisedOptions = new HashSet<>();
        for(String option:options){
            if(VALID_OPTIONS.contains(option)){
                sanitisedOptions.add(option);
            }
        }
        optionHandler.setFileContents(data);
        if (sanitisedOptions == null || sanitisedOptions.size() == 0) {
            // default options
            return optionHandler.getDefaultOptions();
        } else {
            for (String option : sanitisedOptions) {
                switch (option) {
                    case "-c":
                        wordCountResult.add(optionHandler.getByteCount());
                        break;
                    case "-l":
                        wordCountResult.add(optionHandler.getLineCount());
                        break;
                    case "-w":
                        wordCountResult.add(optionHandler.getWordCount());
                        break;
                    case "-m":
                        wordCountResult.add(optionHandler.getCharCount());
                        break;
                    default:
                        break;
                }
            }

        }
        return wordCountResult;
    }
}
