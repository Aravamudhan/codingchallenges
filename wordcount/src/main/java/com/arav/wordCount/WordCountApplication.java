package com.arav.wordCount;

import com.arav.wordCount.service.WordCountService;
import com.arav.wordCount.service.WordCountServiceImpl;
import com.arav.wordCount.utils.FileReader;
import com.arav.wordCount.utils.OptionHandler;
import com.arav.wordCount.utils.ResourceReader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WordCountApplication {
    public static void main(String[] args) throws IOException {
        int lastArgIndex = args.length - 1;
        String fullyQualifiedFileName = "";
        byte[] data = null;
        List<byte[]> dataChunks = new ArrayList<>();
        if(System.in.available()>0){
            Scanner scanner = new Scanner(System.in);
            while(scanner.hasNextLine()){
                String input = scanner.nextLine();
                dataChunks.add(input.getBytes(StandardCharsets.UTF_8));
            }
            data = concatenateByteArrays(dataChunks);
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

    private static byte[] concatenateByteArrays(List<byte[]> byteArrays) {
        // Calculate the total length of the resulting array
        int totalLength = byteArrays.stream().mapToInt(arr -> arr.length).sum();

        // Create a new array to hold the concatenated data
        byte[] result = new byte[totalLength];

        // Copy each byte array to the result array
        int currentIndex = 0;
        for (byte[] byteArray : byteArrays) {
            System.arraycopy(byteArray, 0, result, currentIndex, byteArray.length);
            currentIndex += byteArray.length;
        }

        return result;
    }
}
