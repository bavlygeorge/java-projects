package com.mycompany.spktest;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args){

        YoutubeTitleWordCount y = new YoutubeTitleWordCount();
        //List<Map.Entry> titleRes = y.getWordsCount();
        List<Map.Entry> tagsRes = y.getTagsCount();

        // DISPLAY TOP TITLE WORDS
        /*for (Map.Entry<String, Long> entry : titleRes) {
            System.out.println (entry.getKey () + " : " + entry.getValue ());
        }//*/

        // DISPLAY TOP TAGS
        for (Map.Entry<String, Long> entry : tagsRes) {
            System.out.println (entry.getKey () + " : " + entry.getValue ());
        }//*/
    }
}
