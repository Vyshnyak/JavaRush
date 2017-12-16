package com.javarush.task.task14.task1408;

/**
 * Created by Максим on 09.06.2017.
 */
class MoldovanHen extends Hen {
    @Override
    int getCountOfEggsPerMonth() {
        return 30;
    }

    @Override
    String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
