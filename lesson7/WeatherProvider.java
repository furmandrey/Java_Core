package ru.geekbrains.lesson7;



import ru.geekbrains.lesson7.enums.Periods;

import java.io.IOException;

public interface WeatherProvider {

    public void getWeather(Periods period) throws IOException;



    public void getWeatherIn5Days(Periods period) throws IOException;
}
