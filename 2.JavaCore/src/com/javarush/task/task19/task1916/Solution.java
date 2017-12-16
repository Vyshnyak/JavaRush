package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1Name = reader.readLine();
        String file2Name = reader.readLine();

        reader.close();

        List<String> originalList = new ArrayList<String>();
        List<String> editedList = new ArrayList<String>();

        readFromFileToList(file1Name, file2Name, originalList, editedList);
        combineTwoLists(originalList, editedList);
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }

    public static void readFromFileToList(String file1Name, String file2Name,
                                          List<String> originalList, List<String> editedList) throws IOException {
        BufferedReader file1Reader = new BufferedReader(new FileReader(file1Name));
        BufferedReader file2Reader = new BufferedReader(new FileReader(file2Name));

        String file1Line;

        while ((file1Line = file1Reader.readLine()) != null)
            originalList.add(file1Line);

        String file2Line;

        while ((file2Line = file2Reader.readLine()) != null)
            editedList.add(file2Line);

        file1Reader.close();
        file2Reader.close();
    }

    public static void combineTwoLists(List<String> originalList, List<String> editedList) {
        int origListInd = 0;
        int editListInd = 0;

        while (origListInd < originalList.size() || editListInd < editedList.size()) {
            if (origListInd < originalList.size() && editListInd < editedList.size()) {
                if (originalList.get(origListInd).equals(editedList.get(editListInd))) {
                    lines.add(new LineItem(Type.SAME, originalList.get(origListInd)));
                    origListInd++;
                    editListInd++;
                } else if (originalList.get(origListInd).equals(editedList.get(editListInd + 1))) {
                    lines.add(new LineItem(Type.ADDED, editedList.get(editListInd)));
                    editListInd++;
                } else {
                    lines.add(new LineItem(Type.REMOVED, originalList.get(origListInd)));
                    origListInd++;
                }
            }
            else if (origListInd == originalList.size()) {
                lines.add(new LineItem(Type.ADDED, editedList.get(editListInd)));
                editListInd++;
            }
            else {
                lines.add(new LineItem(Type.REMOVED, originalList.get(origListInd)));
                origListInd++;
            }
        }
    }
}
