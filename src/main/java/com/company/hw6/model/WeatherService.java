package com.company.hw6.model;

import com.company.hw6.model.weather.Weather;

public class WeatherService implements Service{
    private Connection connection;
    private Formatter formatter;
    private static final String EMPTY_ERROR = "Вы не ввели город!!!";

    public WeatherService() {
        connection = new Connection();
        formatter = new Formatter();
    }

    @Override
    public String get(String city) {
        if (city.equals("")){
            return EMPTY_ERROR;
        }
        try {
            String info = connection.getInfo(city);
            Weather weather = formatter.parse(info);
            String answer = weather.toString();
            return answer;
        } catch (NullPointerException e){
            return "Неверное название города!";
        } catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
