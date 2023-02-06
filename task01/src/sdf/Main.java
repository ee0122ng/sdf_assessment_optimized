package sdf;

import java.io.File;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        
        String fileName = "";
        // check if there is an input for file name
        if (args.length != 0) {
            fileName = args[0];
        } else {

            System.out.println("Please provide a file name");
        }

        // check if file exists
        File file = new File("./" + fileName);

        if (file.exists()) {

            // create a file hanlder
            FileHandler fh = new FileHandler(file);
            try {
                fh.TextProcessor();
            
                Integer wordCount = fh.getTextCount();
                
                // return the top 10 key-value pairs
                fh.getTextCorpus()
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .map(e -> new AbstractMap.SimpleEntry<>(e.getKey(), (double) Math.round((Double.valueOf(e.getValue())/(double) wordCount)*1000.0)/1000.0))
                    .limit(10)
                    .forEach(System.out::println);
                    
            } catch(IOException e) {
                e.getStackTrace();
            }


        } else {

            System.out.println("File not exists");
        }

    }
}