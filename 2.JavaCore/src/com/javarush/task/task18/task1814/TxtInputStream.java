package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {

    public TxtInputStream(String fileName) throws FileNotFoundException, UnsupportedFileNameException, IOException {
        super(fileName);
        Pattern pattern = Pattern.compile("^.*\\.txt$");
        Matcher matcher = pattern.matcher(fileName);

        if (!matcher.matches()) {
            super.close();
            throw new UnsupportedFileNameException();
        }
    }



    public static void main(String[] args) {
    }
}

