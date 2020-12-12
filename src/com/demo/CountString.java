package com.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountString {
    public static int count(String filename, String word ) throws IOException {
        int count = 0;
        try (FileReader fileReader = new FileReader(filename)){
            try (BufferedReader reader = new BufferedReader(fileReader)){
                String temp = null;
                while ((temp = reader.readLine()) != null){
                    if(temp.length() >= word.length() && temp.indexOf(word) >= 0){
                        count++;
                        temp = temp.substring(temp.indexOf(word) + word.length());
                    }
                }
            }
        }
        return count;
    }
}
