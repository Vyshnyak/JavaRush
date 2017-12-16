package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();

        if (args.length == 0)
            System.exit(1);

        BufferedReader fileReader = new BufferedReader(
                new InputStreamReader(new FileInputStream(fileName)));

        ArrayList<String> lines = new ArrayList<String>();

        String line;
        while ((line = fileReader.readLine()) != null)
            lines.add(line);

        BufferedWriter fileWriter = new BufferedWriter(
                new FileWriter(fileName));

        int newId = Integer.parseInt(lines.get(lines.size() - 1).substring(0, 8).trim()) + 1;

        for (String oneLine : lines) {
            fileWriter.write(oneLine);
            fileWriter.newLine();
        }

        String newLine = String.format("%-8d%-30s%-8s%-4s", newId, args[1],args[2], args[3]);
        fileWriter.write(newLine);

        reader.close();
        fileReader.close();
        fileWriter.flush();
        fileWriter.close();
    }
}
