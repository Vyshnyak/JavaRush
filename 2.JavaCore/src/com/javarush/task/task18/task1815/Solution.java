package com.javarush.task.task18.task1815;

import java.util.List;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements ATableInterface {
        protected ATableInterface decoratedObject;

        public TableInterfaceWrapper(ATableInterface decoratedObject) {
            this.decoratedObject = decoratedObject;
        }

        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());
            decoratedObject.setModel(rows);
        }

        @Override
        public String getHeaderText() {
            return decoratedObject.getHeaderText().toUpperCase();
        }

        @Override
        public void setHeaderText(String newHeaderText) {
            decoratedObject.setHeaderText(newHeaderText);
        }
    }

    public interface ATableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}