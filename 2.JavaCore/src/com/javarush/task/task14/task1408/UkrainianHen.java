package com.javarush.task.task14.task1408;

/**
 * Created by Максим on 09.06.2017.
 */
class UkrainianHen extends Hen {
    @Override
    int getCountOfEggsPerMonth() {
        return 40;
    }

    @Override
    String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
