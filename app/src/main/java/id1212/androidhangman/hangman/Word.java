package id1212.androidhangman.hangman;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

/*
* Helper class for getting a random word from the words.txt file.
* */

public class Word {
    private static File words;
    private static ArrayList<String> listOfWords = new ArrayList<>();

    public String generateRandomWord(Context context) {
        System.out.println("Getting random word");

        listOfWords = scanFile(context);
        int index = new Random().nextInt(listOfWords.size());
        return listOfWords.get(index);
    }


    private ArrayList<String> scanFile(Context context) {
        ArrayList<String> low = new ArrayList<>();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(context.getAssets().open("words.txt"), "UTF-8"));

            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                //process line
                low.add(mLine);
            }
        } catch (IOException e) {
            //log the exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        }

        return low;
    }

}