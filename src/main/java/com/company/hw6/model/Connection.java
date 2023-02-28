package com.company.hw6.model;

import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Connection {

    //через https://developer.accuweather.com
    public static final String API_KEY_ACCUWEATHER = "ZUHKRfYUfwGoEJ9NiVnQZCkl9SSuHZdc";
    //через https://weatherstack.com
    public static final String API_KEY_WEATHERSTACK = "a2ef0f1ca05a5264e164f757e6a89b3e";


// http://api.weatherstack.com/current?access_key=a2ef0f1ca05a5264e164f757e6a89b3e&query=moscow

    public String getInfo(String city) throws Exception{
        StringBuilder stringBuilder = new StringBuilder();

        URL url = new URL("http://api.weatherstack.com/current?access_key=" + API_KEY_WEATHERSTACK + "&query=" + city);
        URLConnection connection = url.openConnection();
        Scanner scanner = new Scanner(connection.getInputStream());
        while (scanner.hasNext()) {
            stringBuilder.append(scanner.nextLine());
        }
        return stringBuilder.toString();
    }
}
