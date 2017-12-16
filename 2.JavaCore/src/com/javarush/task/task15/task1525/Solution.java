package com.javarush.task.task15.task1525;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static
    {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(Statics.FILE_NAME));

            while (reader.ready())
                lines.add(reader.readLine());
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        // решение из статьи - https://habrahabr.ru/post/269667/
        /*try {
            lines = Files.readAllLines(Paths.get(Statics.FILE_NAME), StandardCharsets.UTF_8);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }*/
    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
