package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticManager {
    private static StatisticManager statisticManager;
    private StatisticStorage statisticStorage = new StatisticStorage();

    private StatisticManager() {
    }

    public static StatisticManager getInstance() {
        if (statisticManager == null) {
            statisticManager = new StatisticManager();
        }

        return statisticManager;
    }

    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage;

        private StatisticStorage() {
            this.storage = new HashMap<>();

            for (EventType eventType : EventType.values()) {
                this.storage.put(eventType, new ArrayList<>());
            }
        }

        public Map<EventType, List<EventDataRow>> getStorage() {
            return storage;
        }

        private void put(EventDataRow eventDataRow) {
            EventType eventType = eventDataRow.getType();

            if (storage.containsKey(eventType)) {
                storage.get(eventType).add(eventDataRow);
            } else {
                storage.put(eventType, new ArrayList<>());
            }
        }
    }

    public Map<String, Long> getAdvertisingDataFromStorage() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        Map<String, Long> advertisingStatistic = new TreeMap<>((o1, o2) -> {
            try {
                return dateFormat.parse(o2).compareTo(dateFormat.parse(o1));
            } catch (ParseException e) {
                return 0;
            }
        });

        List<EventDataRow> dataRows = statisticStorage.getStorage().get(EventType.SELECTED_VIDEOS);
        for (EventDataRow dataRow : dataRows) {
            VideoSelectedEventDataRow videoDataRow = (VideoSelectedEventDataRow) dataRow;
            String date = dateFormat.format(videoDataRow.getDate());
            long amount = videoDataRow.getAmount();
            if (advertisingStatistic.containsKey(date)) {
                advertisingStatistic.put(date, amount + advertisingStatistic.get(date));
            } else {
                advertisingStatistic.put(date, amount);
            }
        }
        return advertisingStatistic;
    }

    public Map<String, Map<String, Integer>> getCookDataFromStorage() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        Map<String, Map<String, Integer>> cookWorkloadStatistic = new TreeMap<>((o1, o2) -> {
            try {
                return dateFormat.parse(o2).compareTo(dateFormat.parse(o1));
            } catch (ParseException e) {
                return 0;
            }
        });

        List<EventDataRow> dataRows = statisticStorage.getStorage().get(EventType.COOKED_ORDER);
        for (EventDataRow dataRow : dataRows) {
            CookedOrderEventDataRow cookDataRow = (CookedOrderEventDataRow) dataRow;
            String date = dateFormat.format(cookDataRow.getDate());
            String cookName = cookDataRow.getCookName();
            Integer workloadTime = cookDataRow.getTime();
            if (cookWorkloadStatistic.containsKey(date)) {
                Map<String, Integer> cookData = cookWorkloadStatistic.get(date);
                if (cookData.containsKey(cookName)) {
                    cookData.put(cookName, cookData.get(cookName) + workloadTime);
                } else {
                    cookData.put(cookName, workloadTime);
                }
                cookWorkloadStatistic.put(date, cookData);
            } else {
                Map<String, Integer> cookData = new TreeMap<>();
                cookData.put(cookName, workloadTime);
                cookWorkloadStatistic.put(date, cookData);
            }
        }
        return cookWorkloadStatistic;
    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }
}
