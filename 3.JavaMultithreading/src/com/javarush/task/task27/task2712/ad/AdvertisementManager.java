package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.NoAvailableVideoEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private List<Advertisement> mainVideoPack = new ArrayList<>();
    private List<Advertisement> tempVideoPack = new ArrayList<>();

    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        packVideo(timeSeconds);

        if (mainVideoPack.isEmpty()) {
            StatisticManager.getInstance().register(new NoAvailableVideoEventDataRow(timeSeconds));
        }

        int fullPrice = calculateFullPrice(mainVideoPack);
        int fullDuration = calculateFullDuration(mainVideoPack);
        StatisticManager.getInstance().register(new VideoSelectedEventDataRow(mainVideoPack, fullPrice, fullDuration));
        displayAllSuitableVideos();
    }

    class VideoPackComparator implements Comparator<Advertisement> {
        @Override
        public int compare(Advertisement o1, Advertisement o2) {
            long displayingCost_o1 = o1.getAmountPerOneDisplaying();
            long displayingCost_o2 = o2.getAmountPerOneDisplaying();

            if (displayingCost_o1 < displayingCost_o2) {
                return 1;
            } else if (displayingCost_o1 > displayingCost_o2) {
                return -1;
            }

            int costOfOneSecond_o1 = getCostOfOneSecond(o1, displayingCost_o1);
            int costOfOneSecond_o2 = getCostOfOneSecond(o2, displayingCost_o2);

            return Integer.compare(costOfOneSecond_o1, costOfOneSecond_o2);
        }
    }

    public int getCostOfOneSecond(Advertisement video, double displayingCost) {
        return (int) ((displayingCost / video.getDuration()) * 1000);
    }

    public void displayAllSuitableVideos() {
        mainVideoPack.sort(new VideoPackComparator());
        for (Advertisement video : mainVideoPack) {
            String name = video.getName();
            long displayingCost = video.getAmountPerOneDisplaying();
            int costOfOneSecond = getCostOfOneSecond(video, displayingCost);

            ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d", name, displayingCost, costOfOneSecond));
            video.revalidate();
        }
    }

    public void packVideo(int timeSeconds) {
        for (int i = 0; i < storage.list().size(); i++) {
            Advertisement advertisement = storage.list().get(i);
            int duration = advertisement.getDuration();
            if (isVideoSuitable(advertisement, duration, timeSeconds)) {
                tempVideoPack.add(advertisement);
                recPackVideo(i + 1, 1, timeSeconds - duration);
                if (isTempVideoPackMoreSuitable()) {
                    setSuitablePack();
                }
                tempVideoPack.clear();
            }
        }
    }

    public void recPackVideo(int videoInd, int packInd, int timeSeconds) {
        for (int j = videoInd; j < storage.list().size(); j++) {
            Advertisement advertisement = storage.list().get(j);
            int duration = advertisement.getDuration();
            if (isVideoSuitable(advertisement, duration, timeSeconds)) {
                if (isVideoAdded(packInd)) {
                    tempVideoPack.add(advertisement);
                    recPackVideo(j + 1, packInd + 1, timeSeconds - duration);
                } else if (isVideoMoreSuitable(advertisement, duration, packInd)) {
                    tempVideoPack.set(packInd, advertisement);
                    recPackVideo(j + 1, packInd + 1, timeSeconds - duration);
                }
            }
        }
    }

    public boolean isVideoAdded(int packInd) {
        return tempVideoPack.size() <= packInd;
    }

    public boolean isVideoSuitable(Advertisement advertisement, int duration, int timeSeconds) {
        return duration <= timeSeconds && !tempVideoPack.contains(advertisement) && advertisement.getHits() > 0;
    }

    public boolean isVideoMoreSuitable(Advertisement advertisement, int duration, int packInd) {
        return advertisement.getAmountPerOneDisplaying() > tempVideoPack.get(packInd).getAmountPerOneDisplaying() &&
                duration <= tempVideoPack.get(packInd).getDuration();
    }

    public boolean isTempVideoPackMoreSuitable() {
        if (mainVideoPack.isEmpty()) {
            return true;
        }

        int mainPackPrice = calculateFullPrice(mainVideoPack);
        int tempPackPrice = calculateFullPrice(tempVideoPack);

        if (tempPackPrice > mainPackPrice) {
            return true;
        }

        if (tempPackPrice < mainPackPrice) {
            return false;
        }

        int mainPackDuration = calculateFullDuration(mainVideoPack);
        int tempPackDuration = calculateFullDuration(tempVideoPack);

        if (tempPackDuration > mainPackDuration) {
            return true;
        }

        if (tempPackDuration < mainPackDuration) {
            return false;
        }

        return tempVideoPack.size() < mainVideoPack.size();
    }

    public void setSuitablePack() {
        mainVideoPack.clear();
        mainVideoPack.addAll(tempVideoPack);
    }

    public int calculateFullPrice(List<Advertisement> videoPack) {
        int fullPrice = 0;
        for (Advertisement advertisement : videoPack) {
            fullPrice += advertisement.getAmountPerOneDisplaying();
        }
        return fullPrice;
    }

    public int calculateFullDuration(List<Advertisement> videoPack) {
        int fullDuration = 0;
        for (Advertisement advertisement : videoPack) {
            fullDuration += advertisement.getDuration();
        }
        return fullDuration;
    }
}
