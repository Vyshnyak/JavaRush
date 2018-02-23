package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class StatisticAdvertisementManager {
    private static StatisticAdvertisementManager statisticAdvertisementManager;
    private AdvertisementStorage storage = AdvertisementStorage.getInstance();

    private StatisticAdvertisementManager() {
    }

    public static StatisticAdvertisementManager getInstance() {
        if (statisticAdvertisementManager == null) {
            statisticAdvertisementManager = new StatisticAdvertisementManager();
        }
        return statisticAdvertisementManager;
    }

    public List<Advertisement> getActiveVideoSet() {
        List<Advertisement> activeVideoSet = new ArrayList<>();
        for (Advertisement advertisement : storage.list()) {
            if (advertisement.getHits() > 0) {
                activeVideoSet.add(advertisement);
            }
        }
        return activeVideoSet;
    }

    public List<Advertisement> getArchivedVideoSet() {
        List<Advertisement> archivedVideoSet = new ArrayList<>();
        for (Advertisement advertisement : storage.list()) {
            if (advertisement.getHits() == 0) {
                archivedVideoSet.add(advertisement);
            }
        }
        return archivedVideoSet;
    }
}
