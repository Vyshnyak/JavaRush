package com.javarush.task.task15.task1522;

/**
 * Created by Максим on 18.06.2017.
 */
public class PlanetFactory {
    public Planet getPlanet(String key) {
        if (key.equals(Planet.SUN))
            return Sun.getInstance();
        else if (key.equals(Planet.MOON))
            return Moon.getInstance();
        else if (key.equals(Planet.EARTH))
            return Earth.getInstance();
        else
            return null;
    }
}
