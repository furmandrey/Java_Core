package ru.geekbrains.lesson6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import static java.nio.charset.StandardCharsets.UTF_8;

public class MainHW6 {
    public static void main(String[] args) throws IOException {
        URL target_url = new URL(get1daysURL(TARGET_CITY_ID));
        printResponseData(target_url.openStream());

        target_url = new URL(get5daysURL(TARGET_CITY_ID));
        printResponseData(target_url.openStream());
    }

    static String BASE_URL = "http://dataservice.accuweather.com";

    static String API_KEY = "9odBDDO7ZCq2EfS9TubfwPxQvv20nYT7";

    static Integer TARGET_CITY_ID = 295212;


    static String get1daysURL(Integer cityID) {
        return BASE_URL + "/forecasts/v1/daily/1day/" + cityID + "?apikey=" + API_KEY + "&metric=true";
    }

    static String get5daysURL(Integer cityID) {
        return BASE_URL + "/forecasts/v1/daily/5day/" + cityID + "?apikey=" + API_KEY + "&metric=true";
    }

    static void printResponseData(InputStream in) {
        new BufferedReader(new InputStreamReader(in, UTF_8))
                .lines()
                .forEach(System.out::println);
    }

}
