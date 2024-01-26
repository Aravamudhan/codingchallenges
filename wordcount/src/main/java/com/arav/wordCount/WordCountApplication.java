package com.arav.wordCount;

import com.arav.wordCount.service.WordCountService;
import com.arav.wordCount.service.WordCountServiceImpl;
import com.arav.wordCount.utils.FileReader;
import com.arav.wordCount.utils.OptionHandler;
import com.arav.wordCount.utils.ResourceReader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WordCountApplication {
    public static void main(String[] args) throws IOException {
        int lastArgIndex = args.length - 1;
        String fullyQualifiedFileName = "";
        byte[] data = null;
        if(System.in.available()>0){
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();
            System.out.println(System.in.available());
            data = input.getBytes(StandardCharsets.UTF_8);
        } else if(lastArgIndex<0){
            System.out.println("No arguments passed");
            return;
        } else {
            fullyQualifiedFileName = args[lastArgIndex];
            ResourceReader resourceReader = new FileReader();
            data = resourceReader.readResource(fullyQualifiedFileName);
        }
        WordCountService wordCountService = new WordCountServiceImpl(new OptionHandler());
        List<Integer> results = wordCountService.getWordCount(data,args);
        String result = results.stream().map(num->num+" ").collect(Collectors.joining());
        System.out.println(result + fullyQualifiedFileName);
    }
}
