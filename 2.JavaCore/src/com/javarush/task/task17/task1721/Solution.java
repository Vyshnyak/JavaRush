package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    static {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader fileReader1 = new BufferedReader(new FileReader(reader.readLine()));
            BufferedReader fileReader2 = new BufferedReader(new FileReader(reader.readLine()));

            while (fileReader1.ready())
                allLines.add(fileReader1.readLine());

            while (fileReader2.ready())
                forRemoveLines.add(fileReader2.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        try {
            solution.joinData();
        }
        catch (CorruptedDataException e) {
            e.printStackTrace();
        }
    }

    public void joinData () throws CorruptedDataException {

        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        }
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
