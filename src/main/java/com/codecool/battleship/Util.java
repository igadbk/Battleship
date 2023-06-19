package com.codecool.battleship;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Util {
    public static String makeHeader(int size){
        char[] letters = getLetters(size, true);
        StringBuilder header = new StringBuilder("  ");
        for (char letter: letters) {
            header.append(" ").append(letter);
        }
        return String.valueOf(header);
    }
    public static char[] getLetters(int count, boolean capital){
        char[] alphabet = new char[count];
        int a;
        if(capital)
            a = 65;
        else
            a = 97;
        for (int i = 0; i < count; i++) {
            alphabet[i] = (char) (a + i);
        }
        return alphabet;
    }
    public static void readFile(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String textLine;
        try {
            while ((textLine = br.readLine()) != null) {
                System.out.println(textLine);
            }
        } catch (IOException e) {
            System.out.println("not working yet");
        }
    }
}
