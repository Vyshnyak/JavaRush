package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementStorage {
    private static AdvertisementStorage storage;
    private final List<Advertisement> videos = new ArrayList<>();

    private AdvertisementStorage() {
        Object someContent = new Object();
        videos.add(new Advertisement(someContent, "четвортое видео", 2000, 1, 5 * 60));
        videos.add(new Advertisement(someContent, "Fifth Video", 500, 1, 2 * 60));
        videos.add(new Advertisement(someContent, "Six Video", 1500, 1, 9 * 60));
        videos.add(new Advertisement(someContent, "Seven Video", 3000, 1, 20 * 60));
    }

    public static AdvertisementStorage getInstance() {
        if (storage == null) {
            storage = new AdvertisementStorage();
        }
        return storage;
    }

    public List<Advertisement> list() {
        return videos;
    }

    public void add(Advertisement advertisement) {
        videos.add(advertisement);
    }
}
