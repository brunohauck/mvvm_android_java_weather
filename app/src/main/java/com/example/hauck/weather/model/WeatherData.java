package com.example.luara.desafiotruckpad.model;

import java.io.Serializable;
import java.util.List;

public class WeatherData implements Serializable {
    private final static String ICON_ADDR = "http://openweathermap.org/img/w/";

    static class Weather {
        String description;
        String icon;
    }

    static class Main {
        float temp;
    }

    List<Weather> weather;

    Main main;

    String name;


    public String getTemperatureInCelsius() {
        float temp = main.temp - 273.15f;
        return String.format("%.2f", temp);
    }

    public String getIconAddress() {
        return ICON_ADDR + weather.get(0).icon + ".png";
    }

    public String getDescription() {
        if (weather != null && weather.size() > 0)
            return weather.get(0).description;
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
