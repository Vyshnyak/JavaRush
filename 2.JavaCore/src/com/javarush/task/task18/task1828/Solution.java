package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();
        reader.close();

        if (args.length == 0)
            System.exit(1);

        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

        ArrayList<String> lines = new ArrayList<String>();
        fillList(fileReader, lines);
        fileReader.close();

        BufferedWriter fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));

        if (args[0].equals("-u"))
            updateLine(lines, args[1], args[2], args[3], args[4]);
        else if (args[0].equals("-d"))
            deleteLine(lines, args[1]);

        writeList(fileWriter, lines);

        fileWriter.flush();
        fileWriter.close();
    }

    public static void fillList(BufferedReader fileReader, List<String> lines) throws IOException {
        String line;
        while ((line = fileReader.readLine()) != null)
            lines.add(line);
    }

    public static void updateLine(ArrayList<String> lines, String id, String productName, String price, String quantity) throws IOException {
        String updatedLine = String.format("%-8s%-30s%-8s%-4s", id, productName, price, quantity);

        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).substring(0, 8).trim().equals(id))
                lines.set(i, updatedLine);
        }
    }

    public static void deleteLine(ArrayList<String> lines, String id) throws IOException {
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).substring(0, 8).trim().equals(id))
                lines.remove(i);
        }
    }

    public static void writeList(BufferedWriter fileWriter, ArrayList<String> lines) throws IOException {
        for (String oneLine : lines) {
            if (lines.size() > 0) {
                fileWriter.write(oneLine);
                fileWriter.newLine();
            }
        }
    }
}
