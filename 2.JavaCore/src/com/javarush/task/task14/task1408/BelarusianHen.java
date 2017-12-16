package com.javarush.task.task14.task1408;

/**
 * Created by Максим on 09.06.2017.
 */
class BelarusianHen extends Hen {
    @Override
    int getCountOfEggsPerMonth() {
        return 35;
    }

    @Override
    String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.BELARUS + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
