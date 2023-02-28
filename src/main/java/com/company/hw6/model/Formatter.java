package com.company.hw6.model;

import com.company.hw6.model.weather.Weather;
import com.google.gson.Gson;

public class Formatter {
    public Weather parse(String info) {
        Gson gson = new Gson();
        Weather weather = gson.fromJson(info, Weather.class);
        return weather;
    }
}
