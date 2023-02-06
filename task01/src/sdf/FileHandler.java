package sdf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class FileHandler {

    private HashMap<String, Integer> textCorpus = new HashMap<>();
    private File file;
    private Integer textCount = 0;

    public HashMap<String, Integer> getTextCorpus() {
        return textCorpus;
    }

    public Integer getTextCount() {
        return textCount;
    }

    public FileHandler(File file) {

        this.file = file;

    }

    public void TextProcessor() throws IOException {

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String line = "";

        while(null != (line = br.readLine())) {

            // skip to next loop if the line is blank or a new line
            if (line.isBlank()) {
                continue;
            }

            // process the text line
            String[] textArray = line.replaceAll("[.,:!-(){}'\"\n\t]", "")
                                        .toLowerCase()
                                        .trim()
                                        .split(" ");

            // increment the text count
            this.textCount += textArray.length;

            // insert the word into the map and update the count
            for (String word : textArray) {
                if (textCorpus.containsKey(word)) {
                    textCorpus.put(word, textCorpus.get(word) + 1);
                } else {
                    textCorpus.put(word, 1);
                }
            } 
        }
        br.close();
        fr.close();

    }
    
}
